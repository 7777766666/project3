package com.bank.history.convertors;

import com.bank.history.models.History;
import com.bank.history.models.dto.HistoryDTO;

public class HistoryConvertor {

    public static History historyDTOToHistory(HistoryDTO historyDTO) {
        History history = new History(historyDTO.getId(), historyDTO.getTransferAuditId(), historyDTO.getProfileAuditId(),
                historyDTO.getAccountAuditId(), historyDTO.getAntiFraudAuditId(), historyDTO.getPublicBankInfoAuditId(),
                historyDTO.getAuthorizationAuditId());
        return history;
    }

    public static HistoryDTO historyToHistoryDTO(History history) {
        HistoryDTO historyDTO = new HistoryDTO(history.getId(), history.getTransferAuditId(), history.getProfileAuditId(),
                history.getAccountAuditId(), history.getAntiFraudAuditId(), history.getPublicBankInfoAuditId(),
                history.getAuthorizationAuditId());
        return historyDTO;
    }
}