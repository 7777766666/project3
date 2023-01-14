package com.bank.history.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NonNull
@Size(max = 8)
@EqualsAndHashCode
@ToString(exclude = "id")
@Table(name = "history")
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "transfer_audit_id")
    Long transferAuditId;
    @Column(name = "profile_audit_id")
    Long profileAuditId;
    @Column(name = "account_audit_id")
    Long accountAuditId;
    @Column(name = "anti_fraud_audit_id")
    Long antiFraudAuditId;
    @Column(name = "public_bank_info_audit_id")
    Long publicBankInfoAuditId;
    @Column(name = "authorization_audit_id")
    Long authorizationAuditId;

    public History(Long transferAuditId, Long profileAuditId, Long accountAuditId, Long antiFraudAuditId, Long publicBankInfoAuditId, Long authorizationAuditId) {
        this.transferAuditId = transferAuditId;
        this.profileAuditId = profileAuditId;
        this.accountAuditId = accountAuditId;
        this.antiFraudAuditId = antiFraudAuditId;
        this.publicBankInfoAuditId = publicBankInfoAuditId;
        this.authorizationAuditId = authorizationAuditId;
    }
}


