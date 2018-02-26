package com.application.domainchallenge.data.entity.mapper;

import com.application.domainchallenge.data.entity.Example;
import com.google.gson.JsonSyntaxException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 * Created by anbu.ezhilan on 26/2/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class ListingEntityJsonMapperTest {

    private static final String JSON_RESPONSE_PROPERTY_LISTINGS = "{\n" +
            "\t\"Ads\": null,\n" +
            "\t\"ClusterResults\": null,\n" +
            "\t\"GeographicWindow\": {\n" +
            "\t\t\"MaximumLatLng\": {\n" +
            "\t\t\t\"Latitude\": -33.88666043090821,\n" +
            "\t\t\t\"Longitude\": 151.2753612060547\n" +
            "\t\t},\n" +
            "\t\t\"MinimumLatLng\": {\n" +
            "\t\t\t\"Latitude\": -33.899495269775386,\n" +
            "\t\t\t\"Longitude\": 151.2566669921875\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\"ListingResults\": {\n" +
            "\t\"Listings\": [\n" +
            "\t{\n" +
            "\t\t\"AdId\": 2014194436,\n" +
            "\t\t\"AgencyColour\": \"#262B2E\",\n" +
            "\t\t\"AgencyContactPhoto\": \"https://images.domain.com.au/img/22908/contact_1133128.JPG?mod=180224-184533\",\n" +
            "\t\t\"AgencyID\": 22908,\n" +
            "\t\t\"AgencyLogoUrl\": \"https://images.domain.com.au/img/Agencys/22908/logo_22908.GIF\",\n" +
            "\t\t\"Area\": \"Eastern Suburbs\",\n" +
            "\t\t\"AuctionDate\": \"2018-03-17T09:00:00\",\n" +
            "\t\t\"AvailableFrom\": null,\n" +
            "\t\t\"Bathrooms\": 3,\n" +
            "\t\t\"Bedrooms\": 4,\n" +
            "\t\t\"Carspaces\": 1,\n" +
            "\t\t\"DateFirstListed\": \"/Date(1519183929000+1100)/\",\n" +
            "\t\t\"DateUpdated\": \"2018-02-21T14:32:09\",\n" +
            "\t\t\"Description\": \"A Bright And Breezy Bondi Beach House, Sweeping Elevated District Views To The Ocean \\n\\nWith its easy breezy beach house feel and family focused layout, this freestanding home stands as testament to carefree living with airy open interiors that capture Bondi's endless summer vibes. Simple pared back interiors spill outdoors with a sandstone walled garden framed by magnolias that's a perfect play space in the day and an alluring entertainer's haven by night. Spread over three levels with a...\",\n" +
            "\t\t\"DisplayPrice\": \"Buyers Guide: $2.8m\",\n" +
            "\t\t\"DisplayableAddress\": \"1 Moore Street, Bondi\",\n" +
            "\t\t\"EnquiryTimeStamp\": null,\n" +
            "\t\t\"Features\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"Name\": \"built in wardrobes\",\n" +
            "\t\t\t\"Value\": \"1\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"Name\": \"ensuite\",\n" +
            "\t\t\t\"Value\": \"1\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"Name\": \"gas\",\n" +
            "\t\t\t\"Value\": \"1\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"Name\": \"internal laundry\",\n" +
            "\t\t\t\"Value\": \"1\"\n" +
            "\t\t}\n" +
            "\t\t],\n" +
            "\t\t\"FreshnessLevel\": 2,\n" +
            "\t\t\"GroupCount\": 0,\n" +
            "\t\t\"GroupNo\": 0,\n" +
            "\t\t\"HasEnhancedVideoUrl\": 0,\n" +
            "\t\t\"Headline\": \"Buyers Guide: $2.8m\",\n" +
            "\t\t\"HomepassEnabled\": true,\n" +
            "\t\t\"ImageUrls\": [\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_1_pi_180221_033210-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_2_pi_180221_033211-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_3_pi_180221_033210-w964-h684\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_4_pi_180221_033212-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_5_pi_180221_033210-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_6_pi_180221_033213-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_7_pi_180221_033210-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_8_pi_180221_033212-w964-h644\",\n" +
            "\t\t\"https://bucket-api.domain.com.au/v1/bucket/image/2014194436_9_pi_180221_033213-w964-h644\"\n" +
            "\t\t],\n" +
            "\t\t\"Images\": null,\n" +
            "\t\t\"InspectionDate\": \"2018-03-01T10:15:00\",\n" +
            "\t\t\"Inspections\": null,\n" +
            "\t\t\"IsBranded\": 0,\n" +
            "\t\t\"IsElite\": 1,\n" +
            "\t\t\"IsPriority\": 0,\n" +
            "\t\t\"Latitude\": -33.89106369018555,\n" +
            "\t\t\"ListingPrice\": 0,\n" +
            "\t\t\"ListingStatistics\": null,\n" +
            "\t\t\"ListingType\": \"Listing\",\n" +
            "\t\t\"ListingTypeString\": \"P+\",\n" +
            "\t\t\"Longitude\": 151.26513671875,\n" +
            "\t\t\"MapCertainty\": 8,\n" +
            "\t\t\"Mode\": null,\n" +
            "\t\t\"ProjectDetails\": null,\n" +
            "\t\t\"PropertyType\": \"House\",\n" +
            "\t\t\"PropertyTypeList\": null,\n" +
            "\t\t\"Region\": \"Sydney Region\",\n" +
            "\t\t\"RetinaDisplayThumbUrl\": \"https://b.domainstatic.com.au/2014194436_1_pi_180221_033210-w964-h644-w298-h223\",\n" +
            "\t\t\"SecondRetinaDisplayThumbUrl\": \"https://b.domainstatic.com.au/2014194436_2_pi_180221_033211-w964-h644-w298-h223\",\n" +
            "\t\t\"SecondThumbUrl\": \"https://b.domainstatic.com.au/2014194436_2_pi_180221_033211-w964-h644-w150-h110\",\n" +
            "\t\t\"State\": \"NSW\",\n" +
            "\t\t\"StatusLabel\": \"New\",\n" +
            "\t\t\"Suburb\": \"BONDI\",\n" +
            "\t\t\"ThumbUrl\": \"https://b.domainstatic.com.au/2014194436_1_pi_180221_033210-w964-h644-w150-h110\",\n" +
            "\t\t\"TopSpotEligible\": 0,\n" +
            "\t\t\"TruncatedDescription\": \"Buyers Guide: $2.8m\\r\\nA Bright And Breezy Bondi Beach House, Sweeping Elevated District Views To The Ocean \\n\\nWith its easy breezy beach house feel and family focused layout, this freestanding home stands as testament to carefree living with a...\",\n" +
            "\t\t\"UnderOfferOrContract\": 0,\n" +
            "\t\t\"VideoUrl\": null\n" +
            "\t}\n" +
            "\t],\n" +
            "\t\"ResultsReturned\": 33,\n" +
            "\t\"ResultsTotal\": 33,\n" +
            "\t\"TopSpotAgencyBanner\": null,\n" +
            "\t\"TopSpotAgencyID\": 0,\n" +
            "\t\"TopSpotBackgroundColor\": null,\n" +
            "\t\"TopSpotListingsCount\": 0\n" +
            "},\n" +
            "\n" +
            "\t\"NavigatorResults\": {},\n" +
            "\t\"PoiMarkerResults\": {\n" +
            "\t\t\"PoiMarkers\": [],\n" +
            "\t\t\"ResultsReturned\": 0,\n" +
            "\t\t\"ResultsTotal\": 0\n" +
            "\t}\n" +
            "}\n";


    private ListingEntityJsonMapper listingEntityJsonMapper;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        listingEntityJsonMapper = new ListingEntityJsonMapper();
    }

    @Test
    public void testTransformListingEntityHappyCase() {
        Example listingEntity =
                listingEntityJsonMapper.transformListingEntityCollection(JSON_RESPONSE_PROPERTY_LISTINGS);

        assertThat(listingEntity.getListingResults().getListingEntities().get(0).getAdId(),
                is(equalTo(2014194436)));
    }

    @Test
    public void testTransformListingEntityNotValidResponse() {
        expectedException.expect(JsonSyntaxException.class);
        listingEntityJsonMapper.transformListingEntityCollection("Dummylistings");
    }
}
