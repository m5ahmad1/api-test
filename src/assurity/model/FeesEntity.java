package assurity.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

/**
*
* @author Mohammad Ahmad
* November, 2018
*
*/
public class FeesEntity {

	@SerializedName("Bundle")
	private Integer bundle;
	@SerializedName("EndDate")
	private Double endDate;
	@SerializedName("Feature")
	private Integer feature;
	@SerializedName("Gallery")
	private Integer gallery;
	@SerializedName("Listing")
	private Integer listing;
	@SerializedName("Reserve")
	private Double reserve;
	@SerializedName("Subtitle")
	private Double subtitle;
	@SerializedName("TenDays")
	private Double tenDays;
	@SerializedName("ListingFeeTiers")
	private List<ListingFeeTierEntity> listingFeeTiers = null;
	@SerializedName("SecondCategory")
	private Double secondCategory;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getBundle() {
		return bundle;
	}

	public void setBundle(Integer bundle) {
		this.bundle = bundle;
	}

	public Double getEndDate() {
		return endDate;
	}

	public void setEndDate(Double endDate) {
		this.endDate = endDate;
	}

	public Integer getFeature() {
		return feature;
	}

	public void setFeature(Integer feature) {
		this.feature = feature;
	}

	public Integer getGallery() {
		return gallery;
	}

	public void setGallery(Integer gallery) {
		this.gallery = gallery;
	}

	public Integer getListing() {
		return listing;
	}

	public void setListing(Integer listing) {
		this.listing = listing;
	}

	public Double getReserve() {
		return reserve;
	}

	public void setReserve(Double reserve) {
		this.reserve = reserve;
	}

	public Double getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(Double subtitle) {
		this.subtitle = subtitle;
	}

	public Double getTenDays() {
		return tenDays;
	}

	public void setTenDays(Double tenDays) {
		this.tenDays = tenDays;
	}

	public List<ListingFeeTierEntity> getListingFeeTiers() {
		return listingFeeTiers;
	}

	public void setListingFeeTiers(List<ListingFeeTierEntity> listingFeeTiers) {
		this.listingFeeTiers = listingFeeTiers;
	}

	public Double getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(Double secondCategory) {
		this.secondCategory = secondCategory;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
