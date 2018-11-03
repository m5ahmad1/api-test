package assurity.test;

/**
 *
 * @author Mohammad Ahmad
 * November, 2018
 *
 */
public enum TestType
{
	RESPONSE_CODE("Response Code"), RESPONSE_CONTENT_TYPE("Response Content Type"),
	RESPONSE_NAME_CRITERIA("Response Name Criteria"), RESPONSE_CANRELIST_CRITERIA("Response CanRelist Criteria"),
	RESPONSE_PROMOTIONS_CRITERIA("Response Promotions Criteria");

    private String testType;

    public String getTestType() {
        return this.testType;
    }

    private TestType(String testType) {
        this.testType = testType;
    }
}
