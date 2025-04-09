package com.paysgift.orderservice.service.impl;

import com.paysgift.orderservice.domain.CartDelete;
import com.paysgift.orderservice.repository.CartDeleteRepository;
import com.paysgift.orderservice.service.CartDeleteService;
import com.paysgift.orderservice.service.dto.CartDeleteDTO;
import com.paysgift.orderservice.service.mapper.CartDeleteMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.paysgift.orderservice.domain.CartDelete}.
 */
@Service
@Transactional
public class CartDeleteServiceImpl implements CartDeleteService {

    private static final Logger LOG = LoggerFactory.getLogger(CartDeleteServiceImpl.class);

    private final CartDeleteRepository cartDeleteRepository;

    private final CartDeleteMapper cartDeleteMapper;

    public CartDeleteServiceImpl(CartDeleteRepository cartDeleteRepository, CartDeleteMapper cartDeleteMapper) {
        this.cartDeleteRepository = cartDeleteRepository;
        this.cartDeleteMapper = cartDeleteMapper;
    }

    @Override
    public CartDeleteDTO save(CartDeleteDTO cartDeleteDTO) {
        LOG.debug("Request to save CartDelete : {}", cartDeleteDTO);
        CartDelete cartDelete = cartDeleteMapper.toEntity(cartDeleteDTO);
        cartDelete = cartDeleteRepository.save(cartDelete);
        return cartDeleteMapper.toDto(cartDelete);
    }

    @Override
    public CartDeleteDTO update(CartDeleteDTO cartDeleteDTO) {
        LOG.debug("Request to update CartDelete : {}", cartDeleteDTO);
        CartDelete cartDelete = cartDeleteMapper.toEntity(cartDeleteDTO);
        cartDelete = cartDeleteRepository.save(cartDelete);
        return cartDeleteMapper.toDto(cartDelete);
    }

    @Override
    public Optional<CartDeleteDTO> partialUpdate(CartDeleteDTO cartDeleteDTO) {
        LOG.debug("Request to partially update CartDelete : {}", cartDeleteDTO);

        return cartDeleteRepository
            .findById(cartDeleteDTO.getId())
            .map(existingCartDelete -> {
                cartDeleteMapper.partialUpdate(existingCartDelete, cartDeleteDTO);

                return existingCartDelete;
            })
            .map(cartDeleteRepository::save)
            .map(cartDeleteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CartDeleteDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all CartDeletes");
        return cartDeleteRepository.findAll(pageable).map(cartDeleteMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CartDeleteDTO> findOne(Long id) {
        LOG.debug("Request to get CartDelete : {}", id);
        return cartDeleteRepository.findById(id).map(cartDeleteMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete CartDelete : {}", id);
        cartDeleteRepository.deleteById(id);
    }
}
