package com.bank.history.services.model;

import com.bank.history.convertors.HistoryConvertor;
import com.bank.history.exception.ResourceNotFoundException;
import com.bank.history.models.History;
import com.bank.history.models.dto.HistoryDTO;
import com.bank.history.repositories.HistoryRepository;
import com.bank.history.services.abstracts.HistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public void save(History history) {
        historyRepository.save(history);
    }

    @Override
    public HistoryDTO getById(Long id) {
        Optional<History> history = historyRepository.findById(id);
        if (history.isEmpty()){
            return null;
        }
        HistoryDTO historyDTO = HistoryConvertor.historyToHistoryDTO(history.get());
        return historyDTO;
    }

    @Override
    public List<HistoryDTO> getAllHistories() {
        List<HistoryDTO> historyDTO = historyRepository.findAll().stream().map(HistoryConvertor::historyToHistoryDTO)
                .toList();
        return historyDTO;
    }

    public History findById(Long id) {
        return historyRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("History with id " + id + " not found"));
    }

    @Override
    @Transactional
    public boolean update(Long id, History history) {

        Optional<History> history2 = historyRepository.findById(id);
        if (history2.isPresent()) {
            History history1 = history2.get();
            history1.setAuthorizationAuditId(history.getAuthorizationAuditId());
            history1.setAccountAuditId(history.getAccountAuditId());
            history1.setPublicBankInfoAuditId(history.getPublicBankInfoAuditId());
            history1.setProfileAuditId(history.getProfileAuditId());
            history1.setAntiFraudAuditId(history.getAntiFraudAuditId());
            history1.setTransferAuditId(history.getTransferAuditId());
            historyRepository.save(history1);
            return true;

        }
        return false;

    }


}
