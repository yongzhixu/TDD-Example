package tdd.pratice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdd.pratice.service.AccountService;
import tdd.pratice.domain.PriceAccount;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("price-accounts")
public class PriceAccountController {


    private final AccountService accountService;

    public PriceAccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * POST /price-accounts/add : add one or more new PriceAccount(s)
     * add one or more new PriceAccount(s)
     *
     * @param priceAccount PriceAccounts to be saved (required)
     * @return successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Not Found (status code 404)
     */
    @PostMapping(
            value = "/add",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<String> addAccounts(@Valid @RequestBody List<PriceAccount> priceAccounts) {
        accountService.addAccounts(priceAccounts);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * GET /price-accounts/read/{smartMeterId} : read data from a specific smart meter
     * query by smart meter id
     *
     * @param smartMeterId  (required)
     * @return successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Not Found (status code 404)
     */
    @GetMapping(
            value = "/read/{smartMeterId}",
            produces = { "application/json" }
    )
    public ResponseEntity<PriceAccount> readPriceAccountForSmartMeterId(@Size(min=1,max=50) @PathVariable("smartMeterId") String smartMeterId) {
        PriceAccount priceAccount=new PriceAccount();
        priceAccount.setPlanName(accountService.getPricePlanIdForSmartMeterId(smartMeterId));
        priceAccount.setSmartMeterId(smartMeterId);
        return new ResponseEntity<>(priceAccount,HttpStatus.OK);
    }

}
