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
public class DetailsEntity {

	@SerializedName("CategoryId")
	private Integer categoryId;
	@SerializedName("Name")
	private String name;
	@SerializedName("Path")
	private String path;
	@SerializedName("CanListAuctions")
	private Boolean canListAuctions;
	@SerializedName("CanListClassifieds")
	private Boolean canListClassifieds;
	@SerializedName("CanRelist")
	private Boolean canRelist;
	@SerializedName("LegalNotice")
	private String legalNotice;
	@SerializedName("DefaultDuration")
	private Integer defaultDuration;
	@SerializedName("AllowedDurations")
	private List<Integer> allowedDurations = null;
	@SerializedName("Fees")
	private FeesEntity fees;
	@SerializedName("FreePhotoCount")
	private Integer freePhotoCount;
	@SerializedName("MaximumPhotoCount")
	private Integer maximumPhotoCount;
	@SerializedName("IsFreeToRelist")
	private Boolean isFreeToRelist;
	@SerializedName("Promotions")
	private List<PromotionEntity> promotions = null;
	@SerializedName("EmbeddedContentOptions")
	private List<Object> embeddedContentOptions = null;
	@SerializedName("MaximumTitleLength")
	private Integer maximumTitleLength;
	@SerializedName("AreaOfBusiness")
	private Integer areaOfBusiness;
	@SerializedName("DefaultRelistDuration")
	private Integer defaultRelistDuration;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getCanListAuctions() {
		return canListAuctions;
	}

	public void setCanListAuctions(Boolean canListAuctions) {
		this.canListAuctions = canListAuctions;
	}

	public Boolean getCanListClassifieds() {
		return canListClassifieds;
	}

	public void setCanListClassifieds(Boolean canListClassifieds) {
		this.canListClassifieds = canListClassifieds;
	}

	public Boolean getCanRelist() {
		return canRelist;
	}

	public void setCanRelist(Boolean canRelist) {
		this.canRelist = canRelist;
	}

	public String getLegalNotice() {
		return legalNotice;
	}

	public void setLegalNotice(String legalNotice) {
		this.legalNotice = legalNotice;
	}

	public Integer getDefaultDuration() {
		return defaultDuration;
	}

	public void setDefaultDuration(Integer defaultDuration) {
		this.defaultDuration = defaultDuration;
	}

	public List<Integer> getAllowedDurations() {
		return allowedDurations;
	}

	public void setAllowedDurations(List<Integer> allowedDurations) {
		this.allowedDurations = allowedDurations;
	}

	public FeesEntity getFees() {
		return fees;
	}

	public void setFees(FeesEntity fees) {
		this.fees = fees;
	}

	public Integer getFreePhotoCount() {
		return freePhotoCount;
	}

	public void setFreePhotoCount(Integer freePhotoCount) {
		this.freePhotoCount = freePhotoCount;
	}

	public Integer getMaximumPhotoCount() {
		return maximumPhotoCount;
	}

	public void setMaximumPhotoCount(Integer maximumPhotoCount) {
		this.maximumPhotoCount = maximumPhotoCount;
	}

	public Boolean getIsFreeToRelist() {
		return isFreeToRelist;
	}

	public void setIsFreeToRelist(Boolean isFreeToRelist) {
		this.isFreeToRelist = isFreeToRelist;
	}

	public List<PromotionEntity> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<PromotionEntity> promotions) {
		this.promotions = promotions;
	}

	public List<Object> getEmbeddedContentOptions() {
		return embeddedContentOptions;
	}

	public void setEmbeddedContentOptions(List<Object> embeddedContentOptions) {
		this.embeddedContentOptions = embeddedContentOptions;
	}

	public Integer getMaximumTitleLength() {
		return maximumTitleLength;
	}

	public void setMaximumTitleLength(Integer maximumTitleLength) {
		this.maximumTitleLength = maximumTitleLength;
	}

	public Integer getAreaOfBusiness() {
		return areaOfBusiness;
	}

	public void setAreaOfBusiness(Integer areaOfBusiness) {
		this.areaOfBusiness = areaOfBusiness;
	}

	public Integer getDefaultRelistDuration() {
		return defaultRelistDuration;
	}

	public void setDefaultRelistDuration(Integer defaultRelistDuration) {
		this.defaultRelistDuration = defaultRelistDuration;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
