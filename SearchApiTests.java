
package com.appleinterview.exercises;

import org.testng.Assert;

/**
 * Created by jinlingkwang on 8/28/16.
 */
public class SearchApiTests {
    @Test(dataProvider = "ValidDataProvider")
    public void testWithPositiveCases(String querystring) throws Exception {
        StringBuilder requestUrl = new StringBuilder("https://itunes.apple.com/search");
        String querystring = URLEncodedUtils.format(params, "utf-8");
        requestUrl.append("?");
        requestUrl.append(querystring);

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet get = new HttpGet(requestUrl.toString());
        HttpResponse resp = client.execute(httpGet);
        Assert.assertEquals(200, resp.getStatusLine().getStatusCode()); 
    }

    @Test(dataProvider = "InvalidDataProvider")
    public void testWithNegativeCases(String querystring) throws Exception {
        StringBuilder requestUrl = new StringBuilder("https://itunes.apple.com/search");
        String querystring = URLEncodedUtils.format(params, "utf-8");
        requestUrl.append("?");
        requestUrl.append(querystring);

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet get = new HttpGet(requestUrl.toString());
        HttpResponse resp = client.execute(httpGet);
        Assert.assertNotEquals(200, resp.getStatusLine().getStatusCode()); 
    }

     @DataProvider
     public Object[][] ValidDataProvider() {
     		return new Object[][]{
			{"term='jack+johnson'"},
			{"term='jack+johnson'&country=’US’"},
			{"term='jack+johnson'&media=’movie’"},
			{"term='jack+johnson'&limit=25"},
			{"term='jack+johnson'&country=’US’&media=’movie’"},
			{"term='jack+johnson'&country=’US’&limit=1"},
			{"term='jack+johnson'&media=’movie’&limit=10"},
			{"term='jack+johnson'&country=’US’&media=’movie’&limit=10"}
     		};
     }

     @DataProvider
     public Object[][] InvalidDataProvider() {
     		return new Object[][]{
			{""},
			{"country=’US’"},
			{"term="},
			{"term=’%$jonson’&country=’US’"},
			{"term= 'jack+johnson'&country=’foobar’"},
			{"term= 'jack+johnson'&country="},
			{"term= 'jack+johnson'&country=’US’&media=’foobar’"},
			{"term= 'jack+johnson'&country=’US’&media="},
			{"term= 'jack+johnson'&country=’US’&media=’movie’&limit=0"},
			{"term= 'jack+johnson'&country=’US’&media=’movie’&limit=-1"},
			{"term= 'jack+johnson'&country=’US’&media=’movie’&limit="},
     		};
     }
     
}
