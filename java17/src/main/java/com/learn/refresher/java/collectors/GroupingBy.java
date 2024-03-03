package com.learn.refresher.java.collectors;

import lombok.extern.slf4j.Slf4j;
import com.learn.refresher.java.lambda.Trade;
import com.learn.refresher.java.lambda.TradeUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
public class GroupingBy {

    static Supplier<List<Trade>> tradeSupplier = TradeUtil::createTrades;
    static Supplier<List<Employee>> employeeSupplier = EmployeeUtil::createEmployees;
    static Consumer<Map<Boolean, List<Trade>>> printGroupBy = map -> log.info("MapValue : {}", map);
    static Consumer<Map<String, Map<String, List<Employee>>>> printEmployees = map -> log.info("MapValue : {}", map);
    public static void main(String[] args) {
        printGroupBy.accept(groupByOpenTrades());
        printGroupBy.accept(groupByBigTrades());
        printEmployees.accept(employeesByDepartmentAndCity());
    }

    public static Map<String, Map<String, List<Employee>>> employeesByDepartmentAndCity() {
        return employeeSupplier.get().stream().collect(groupingBy(Employee::department, groupingBy(Employee::city)));
    }
    public static Map<Boolean, List<Trade>> groupByOpenTrades() {
        return tradeSupplier.get().stream().collect(groupingBy(Trade::isOpenTrade));
    }

    public static Map<Boolean, List<Trade>> groupByBigTrades() {
        return tradeSupplier.get().stream().collect(groupingBy(Trade::isBigTrade));
    }

}
