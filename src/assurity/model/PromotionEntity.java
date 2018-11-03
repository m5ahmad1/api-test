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
public class PromotionEntity {

	@SerializedName("Id")
	private Integer id;
	@SerializedName("Name")
	private String name;
	@SerializedName("Description")
	private String description;
	@SerializedName("Price")
	private Integer price;
	@SerializedName("MinimumPhotoCount")
	private Integer minimumPhotoCount;
	@SerializedName("OriginalPrice")
	private Integer originalPrice;
	@SerializedName("Recommended")
	private Boolean recommended;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getMinimumPhotoCount() {
		return minimumPhotoCount;
	}

	public void setMinimumPhotoCount(Integer minimumPhotoCount) {
		this.minimumPhotoCount = minimumPhotoCount;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(Boolean recommended) {
		this.recommended = recommended;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}