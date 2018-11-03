package assurity.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;

import assurity.model.DetailsEntity;
import assurity.ui.Constants;

/**
 *
 * @author Mohammad Ahmad
 * November, 2018
 *
 */
public class CriteriaTest {

	private static int responseCode = -1;
	private static String responseContentType = "";
	private static String responseJsonData = "";
	private static DetailsEntity detailsEntity = null;
	@BeforeClass
	public static void setupHttpConnection() {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL(Constants.Endpoint_URL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			responseCode = connection.getResponseCode();
			responseContentType = connection.getContentType();
			responseJsonData = getJsonString(connection);
			detailsEntity = new Gson().fromJson(responseJsonData, DetailsEntity.class);
		} catch (MalformedURLException e) {
			Logger.getLogger("Error").log(Level.SEVERE, null, e);
			fail("URL Failure");
		} catch (ProtocolException e) {
			Logger.getLogger("Error").log(Level.SEVERE, null, e);
			fail("Connection Failure");
		} catch (IOException e) {
			Logger.getLogger("Error").log(Level.SEVERE, null, e);
			fail("IO Connection Failure");
		} finally {
			if (connection != null) {
				try {
					connection.disconnect();
				} catch (Exception e) {
					Logger.getLogger("Error").log(Level.SEVERE, null, e);
				}
			}
		}
	}

	@Test
	public void responseStatusTest() {
		assertTrue("Response code was not received as expected [2xx]\n"
				+ " Verify the Api's Url is correct and the server is running.", (responseCode >=200 && responseCode <= 208) || responseCode == 226 );
	}

	@Test
	public void responseContentTypeTest() {
		assertTrue("Response content type was not received as expected.\n"
				+ " Expected: [application/json] but Received: [" + responseContentType + "]", responseContentType.contains("application/json"));
	}

	@Test
	public void responseNameCriteriaTest() {
		assertNotNull("Response json object is null", detailsEntity);
		assertEquals("Response entity name was not received as expected.\n"
				+ " Expected: [" + Constants.Expected_Name_Criteria +"] but Received: [" + detailsEntity.getName() + "]", Constants.Expected_Name_Criteria.toLowerCase(), detailsEntity.getName().toLowerCase());
	}

	@Test
	public void responseCanRelistCriteriaTest() {
		assertEquals("Response entity's \"CanRelist\" was not received as expected.\n", Constants.Expected_CanRelist_Criteria, detailsEntity.getCanRelist());
	}

	@Test
	public void responsePromotionsCriteriaTest() {
		boolean isPromotionsMeetCriteria = detailsEntity.getPromotions().stream().filter(
				promotion -> promotion.getName().equalsIgnoreCase(Constants.Expected_Promotions_Name_Criteria)
				&& promotion.getDescription().toLowerCase().contains(Constants.Expected_Promotions_Description_Content_Criteria.toLowerCase())).count() != 0;
		assertTrue(" No Promotion found with name: ["+Constants.Expected_Promotions_Name_Criteria+"] that contains the description:"
				+ "["+ Constants.Expected_Promotions_Description_Content_Criteria +"]", isPromotionsMeetCriteria);
	}


	private static String getJsonString(HttpURLConnection c) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(c.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			return sb.toString();

		} catch (IOException e) {
			Logger.getLogger("Error while reading JSON file").log(Level.WARNING, null, e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					Logger.getLogger("Error while closing JSON reader").log(Level.WARNING, null, e);
				}
			}
		}
		return "";
	}

}
