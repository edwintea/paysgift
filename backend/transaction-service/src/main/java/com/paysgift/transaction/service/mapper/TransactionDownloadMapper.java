package com.paysgift.transaction.service.mapper;

import com.paysgift.transaction.domain.TransactionDownload;
import com.paysgift.transaction.service.dto.TransactionDownloadDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TransactionDownload} and its DTO {@link TransactionDownloadDTO}.
 */
@Mapper(componentModel = "spring")
public interface TransactionDownloadMapper extends EntityMapper<TransactionDownloadDTO, TransactionDownload> {}
