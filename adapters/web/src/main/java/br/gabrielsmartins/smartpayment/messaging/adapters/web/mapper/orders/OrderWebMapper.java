package br.gabrielsmartins.smartpayment.messaging.adapters.web.mapper.orders;

import br.gabrielsmartins.smartpayment.messaging.adapters.web.dto.orders.OrderDTO;
import br.gabrielsmartins.smartpayment.messaging.application.domain.orders.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderWebMapper {

    Order mapToDomain(OrderDTO orderDTO);

    OrderDTO mapToDto(Order order);

}
