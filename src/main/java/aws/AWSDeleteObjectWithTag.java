package aws;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectTaggingRequest;
import com.amazonaws.services.s3.model.GetObjectTaggingResult;
import com.amazonaws.services.s3.model.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Intellij Application runner requires "AWS_PROFILE=data-lake-test" environment variable
 * (forcing this profile to be picked up as the "default" profile) for the presto application test to run.
 */

public class AWSDeleteObjectWithTag {

	AmazonS3 s3;

	public AWSDeleteObjectWithTag(){
		s3 = AmazonS3ClientBuilder.defaultClient();
	}

	public static void main(String[] args) {
		AWSDeleteObjectWithTag mgr = new AWSDeleteObjectWithTag();

		String bucket = "sverma-test-bucket";
		String key  = "00000000000000000000.json";

		List<Tag> updatedFileTagSet = getMatcherTags();

		String path = "s3://"+bucket+"/"+key;

		try{
			// Get Object Tags
			GetObjectTaggingResult result = mgr.s3
							.getObjectTagging(new GetObjectTaggingRequest(bucket,key));
			List<Tag> tagSet = result.getTagSet();

			//Get Object ID
			String versionID = result.getVersionId();

			if(tagSet.equals(updatedFileTagSet)){
				System.out.println("Deleting object:[ "+ path+ "], v#[ "+versionID+" ]");
				mgr.s3.deleteVersion(bucket, key, versionID);
			}
		}
		catch(AmazonS3Exception e){
			System.out.println("No Object Found: [ "+ path+" ]" + e.getMessage());
		} catch (Exception e){
			throw e;
		}
	}

	private static List<Tag> getMatcherTags() {
		String pipelineTag="pipeline";
		String pipelineValue="sledgehammer";
		String executionDateTag="executionDate";
		String executionDateValue = "2020-03-12";

		List<Tag> updatedFileTagSet = new ArrayList<>();
		updatedFileTagSet.add(new Tag(pipelineTag, pipelineValue));
		updatedFileTagSet.add(new Tag(executionDateTag, executionDateValue));
		return updatedFileTagSet;
	}

}
