package com.intelcia.repo.specs;

import com.intelcia.model.Employee;
import com.intelcia.model.Projet;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Date;

/**
 * Created by Administrateur on 11/03/2015.
 */
public class EmployeeSpecs {
    public static Specification<Employee> isPoor() {
        return new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                return builder.lessThanOrEqualTo(root.<Integer>get("salary"), 2000);
            }
        };
    }

    public static Specification<Employee> isRich() {
        return new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                return builder.greaterThanOrEqualTo(root.<Integer>get("salary"), 2000);
            }
        };
    }

    public static Specification<Employee> isMidle() {
        return new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                return builder.equal(root.<Integer>get("salary"), 9000);
            }
        };
    }

    public static Specification<Employee> isWorking() {
        return new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {
                Join<Employee,Projet> join =root.join("projets");
                Date from = new Date();
                from.setDate(new Date().getDate() -15);
                return builder.between(join.<Date>get("dateLivraison"),from,new Date());
            }
        };
    }

}
