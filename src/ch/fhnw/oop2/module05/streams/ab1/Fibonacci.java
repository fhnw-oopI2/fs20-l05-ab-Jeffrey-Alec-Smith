package ch.fhnw.oop2.module05.streams.ab1;

import java.util.stream.Stream;

public class Fibonacci {
    
    public static void main(String[] args) {
        Tuple<Integer> startingValue = new Tuple<>(1, 1);
        
        Stream.iterate(startingValue, n->{
            Tuple<Integer> previousValues = (Tuple<Integer>) n;
            Integer sum = previousValues.t1 + previousValues.t2;
            Tuple<Integer> newValues = new Tuple<>(previousValues.t2, sum);
            return newValues;
        })
        .limit(30)
        .forEach(n->{System.out.println(n.t1);});;
    }
    
}
