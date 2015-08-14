package HugeInteger;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HugeInteger {
	
	Integer[] hugeInteger;
	Integer[] otherhugeInt;
	 public Predicate<Integer[]> isEqualTo;
  @RequestMapping("/parse")
	public void parse(@RequestParam(value = "integer") String hgInt){
		hugeInteger = new Integer[hgInt.length()];
		for (int i = 0; i < hgInt.length(); i++)
			hugeInteger[i] = Character.getNumericValue(hgInt.charAt(i)); 
		
		for (int i = 0; i < hgInt.length(); i++)
			System.out.println(hugeInteger[i]); 
		
	
	}
	@RequestMapping("/Add")
	public BigInteger add(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i)); 
		BigInteger b1,b2;
		b1 = new BigInteger(toString(hugeInteger));
		b2 = new BigInteger(toString(hugeInteger2));
		return (b1.add(b2))	;	
	}
	@RequestMapping("/Subtract")
	public BigInteger subtract(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i)); 
		BigInteger b1,b2;
		b1 = new BigInteger(toString(hugeInteger));
		b2 = new BigInteger(toString(hugeInteger2));
		return (b1.subtract(b2));	
	}
	
	
	@RequestMapping("/Equals")
	public boolean isEqualTo(
			@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++) {
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i)); 
			otherhugeInt[i] = hugeInteger2[i];
		}
			System.out.println(toString(otherhugeInt));
		
		isEqualTo =(num) ->{	if(hugeInteger.length!=otherhugeInt.length)
			return false;
		for(int i:hugeInteger)
			if(hugeInteger[i]!=otherhugeInt[i])
				return false;
		
		
		return true;
		};
			return isEqualTo.test(otherhugeInt);
	}
	@RequestMapping("/NotEquals")
	public boolean isNotEqualTo(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i));
		if(hugeInteger.length!=hugeInteger2.length)
			return true;
		for(int i:hugeInteger)
			if(hugeInteger[i]!=hugeInteger2[i])
				return true;
		
		
		return false;
	}
	@RequestMapping("/GreaterThan")
	public boolean isGreaterThan(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i));
		if(hugeInteger.length>hugeInteger2.length)
			return true;
		else if(hugeInteger.length>hugeInteger2.length)
			return false;
		else {
			if(hugeInteger[0]>hugeInteger2[0])
				return true;
			else
				return false;
			
		}
		
		
	}
	@RequestMapping("/LesserThan")
	public boolean isLessThan(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i));
		if(hugeInteger.length>hugeInteger2.length)
			return false;
		else if(hugeInteger.length>hugeInteger2.length)
			return true;
		else {
			if(hugeInteger[0]>hugeInteger2[0])
				return false;
			else
				return true;
			
		}
		
	}
	@RequestMapping("/GreaterThanEqual")
	public boolean isGreaterThanOrEqualTo(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i));
		if(hugeInteger.length>hugeInteger2.length)
			return true;
		else if(hugeInteger.length>hugeInteger2.length)
			return false;
		else {
			
			if(hugeInteger[0]>=hugeInteger2[0])
				return true;
			else
				return false;
			
		}
		
	}
	@RequestMapping("/LesserThanEqual")
	public boolean isLessThanOrEqualTo(@RequestParam(value = "integer") String hgInt2){
		Integer[] hugeInteger2 = new Integer[hgInt2.length()];
		for (int i = 0; i < hgInt2.length(); i++)
			hugeInteger2[i] = Character.getNumericValue(hgInt2.charAt(i));
		if(hugeInteger.length>hugeInteger2.length)
			return false;
		else if(hugeInteger.length>hugeInteger2.length)
			return true;
		else {
			if(hugeInteger[0]<=hugeInteger2[0])
				return true;
			else
				return false;
			
		}
		
		
	}
	
	Predicate<Integer> isZero = new Predicate<Integer>() {
	   
		@Override
		public boolean test(Integer t) {
			// TODO Auto-generated method stub
			return t != 0;
		}       
	};
	
	@RequestMapping("/Zero")
	public boolean isZero(){
		List<Integer> numList = Arrays.asList(hugeInteger);
		return numList.stream()
		.map(t -> t == 0)
		.reduce(true, (x,y) -> x && y);
	}
	@RequestMapping("/Test")
	public String test(@RequestParam(value="name") String name){
		return name;
	}
	
	@RequestMapping("/toString")
	public String toString(){
		StringBuilder hgInt = new StringBuilder();
		for (int i:hugeInteger)
			hgInt.append((int)i);
		
		return hgInt.toString();
	}
	public String toString(Integer[] hugeIntegers) { 
		StringBuilder hgInt = new StringBuilder();
		for (int i:hugeIntegers)
			hgInt.append((int)i);
		
		return hgInt.toString();
		
		
	}

}
