package tdd.pratice.service;

import org.springframework.stereotype.Service;
import tdd.pratice.domain.PriceAccount;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final Map<String, String> smartMeterToPricePlanAccounts;

    public AccountService(Map<String, String> smartMeterToPricePlanAccounts) {
        this.smartMeterToPricePlanAccounts = smartMeterToPricePlanAccounts;
    }

    public void addAccounts(List<PriceAccount> priceAccounts) {
        priceAccounts.forEach(priceAccount -> this.smartMeterToPricePlanAccounts.put(priceAccount.getSmartMeterId(),priceAccount.getPlanName()));
        this.smartMeterToPricePlanAccounts.putAll(
                Optional.of(priceAccounts.stream().collect(
                        Collectors.toMap(PriceAccount::getSmartMeterId, PriceAccount::getPlanName))).orElse(Collections.emptyMap()));
    }

    public String getPricePlanIdForSmartMeterId(String smartMeterId) {
        return smartMeterToPricePlanAccounts.get(smartMeterId);
    }
}
