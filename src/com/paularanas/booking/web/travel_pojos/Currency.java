package com.paularanas.booking.web.travel_pojos;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {

	USD, EUR;
	
	
	  @JsonCreator
	    public static Currency fromString(String key) {
	        for(Currency type : Currency.values()) {
	            if(type.name().equalsIgnoreCase(key)) {
	                return type;
	            }
	        }
	        return null;
	    }

}
