package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.dto.customer_dto.CustomerDtoJoin;
import com.codegym.casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String keywordName, Pageable pageable);

    @Query(value = "select customer_code from customer", nativeQuery = true)
    List<String> getCustomerCode();

    Page<Customer> findAllByNameContainingAndCustomerCodeContainingAndCustomerType_Name(String keywordName, String keywordCode, String keywordType, Pageable pageable);

    @Query(value = "select * from customer where `name` like :searchName and customer_code like :searchCode and  customer_type_id like:searchType",
            countQuery = "select * from customer where `name` like :searchName and customer_code like :searchCode and customer_type_id like:searchType",
            nativeQuery = true)
    Page<Customer> findAllByNameCodeType(@Param("searchName") String keywordName,
                                         @Param("searchCode") String keywordCode,
                                         @Param("searchType") String keywordType,
                                         Pageable pageable);

    @Query(value =
            "select customer.id                                                                     as customerId,\n" +
                    "       customer.name                                                                   as name,\n" +
                    "       contract.contract_id                                                            as contractId,\n" +
                    "       GROUP_CONCAT(attach_service.name)                                               as serviceInclude,\n" +
                    "       contract_detail.quantity                                                        as quantity,\n" +
                    "       date_start                                                                      as dateStart,\n" +
                    "       date_end                                                                        as dateEnd,\n" +
                    "       sum(COALESCE(contract_detail.quantity * attach_service.cost, 0)) + service.cost as cost\n" +
                    "from customer\n" +
                    "         join contract on customer.id = contract.customer_id\n" +
                    "         join service on contract.service_id = service.id\n" +
                    "         left join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
                    "         left join attach_service on contract_detail.attact_service_id = attach_service.attact_service_id\n" +
                    "group by contract.contract_id\n",
            countQuery =
                    "select customer.id                                                                     as customerId,\n" +
                            "       customer.name                                                                   as name,\n" +
                            "       contract.contract_id                                                            as contractId,\n" +
                            "       GROUP_CONCAT(attach_service.name)                                               as serviceInclude,\n" +
                            "       contract_detail.quantity                                                        as quantity,\n" +
                            "       date_start                                                                      as dateStart,\n" +
                            "       date_end                                                                        as dateEnd,\n" +
                            "       sum(COALESCE(contract_detail.quantity * attach_service.cost, 0)) + service.cost as cost\n" +
                            "from customer\n" +
                            "         join contract on customer.id = contract.customer_id\n" +
                            "         join service on contract.service_id = service.id\n" +
                            "         left join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
                            "         left join attach_service on contract_detail.attact_service_id = attach_service.attact_service_id\n" +
                            "group by contract.contract_id",
            nativeQuery = true)
    Page<CustomerDtoJoin> findCustomerJoin(Pageable pageable);

    @Query(value = "select email from customer", nativeQuery = true)
    List<String> getEmail();

    @Query(value = "select phone from customer", nativeQuery = true)
    List<String> getPhone();

    @Query(value = "select id_card from customer", nativeQuery = true)
    List<String> getIdCard();
}
