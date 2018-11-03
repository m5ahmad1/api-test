package assurity.model;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
*
* @author Mohammad Ahmad
* November, 2018
*
*/
public class ListingFeeTierEntity {
	@SerializedName("MinimumTierPrice")
	private Integer minimumTierPrice;
	@SerializedName("FixedFee")
	private Integer fixedFee;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getMinimumTierPrice() {
		return minimumTierPrice;
	}

	public void setMinimumTierPrice(Integer minimumTierPrice) {
		this.minimumTierPrice = minimumTierPrice;
	}

	public Integer getFixedFee() {
		return fixedFee;
	}

	public void setFixedFee(Integer fixedFee) {
		this.fixedFee = fixedFee;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
