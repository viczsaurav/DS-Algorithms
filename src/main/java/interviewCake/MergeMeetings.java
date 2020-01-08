package interviewCake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeMeetings {

	public static class Meeting {

		private int startTime;
		private int endTime;

		public Meeting(int startTime, int endTime) {
			// number of 30 min blocks past 9:00 am
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (!(o instanceof Meeting)) {
				return false;
			}
			final Meeting meeting = (Meeting) o;
			return startTime == meeting.startTime && endTime == meeting.endTime;
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = result * 31 + startTime;
			result = result * 31 + endTime;
			return result;
		}

		@Override
		public String toString() {
			return String.format("(%d, %d)", startTime, endTime);
		}
	}

	public static List<Meeting> mergeRangesList(List<Meeting> meetings) {

		// Step 1: Sort according to starting time
		// in-place
		meetings.sort((Meeting m1, Meeting m2)-> m1.startTime-m2.startTime);
		Meeting[] sortedMeetings = meetings.toArray(new Meeting[meetings.size()]);

		// Step 2: Merge if :
		//          array[i].startTime<= array[i+1].startTime &&
		//          array[i].endTime >= array[i+1].startTime
		// while merge: select min(startTime), max(endTime)
		List<Meeting> mergedMeetings = new ArrayList<>();
		Meeting mergedMeeting = sortedMeetings[0];

		for(int i=1;i<sortedMeetings.length;i++){
			Meeting currentMeeting = sortedMeetings[i];
			if (mergedMeeting.getStartTime()<=currentMeeting.getStartTime() &&
							mergedMeeting.getEndTime()>=currentMeeting.getStartTime()){

				mergedMeeting = new Meeting(
								Math.min(mergedMeeting.getStartTime(),currentMeeting.getStartTime()),
								Math.max(mergedMeeting.getEndTime(),currentMeeting.getEndTime()));
			}
			else {
				mergedMeetings.add(mergedMeeting);
				mergedMeeting=currentMeeting;
			}
		}

		mergedMeetings.add(mergedMeeting);
		return mergedMeetings;
	}

	public static List<Meeting> mergeRanges(List<Meeting> meetings) {

		// Create a Copy
		List<Meeting> meetingsCopy = new ArrayList<>();
		for(Meeting m: meetings){
			meetingsCopy.add(new Meeting(m.getStartTime(), m.getEndTime()));
		}

		// Sort the array on startTime
		meetingsCopy.sort((Meeting m1, Meeting m2)-> m1.getStartTime()-m2.getStartTime());

		//Merge meeting : m1.startTime<=m2.startTime && m1.endTime>=m2.startTime
		// For merge : min(m1.startTime, m2.startTime), max(m1.endTime, m2.EndTime)
		List<Meeting> mergedMeetings = new ArrayList<>();
		mergedMeetings.add(meetingsCopy.get(0));

		for(Meeting currMeet : meetingsCopy){
			Meeting lastMergeMeet = mergedMeetings.get(mergedMeetings.size()-1);

			if(lastMergeMeet.getStartTime()<=currMeet.getStartTime() &&
							lastMergeMeet.getEndTime()>=currMeet.getStartTime()){
				lastMergeMeet.setEndTime(
								Math.max(lastMergeMeet.getEndTime(), currMeet.getEndTime()));
			}
			else {
				mergedMeetings.add(currMeet);
			}
		}

		return mergedMeetings;

	}

}