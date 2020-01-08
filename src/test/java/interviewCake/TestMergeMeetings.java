package interviewCake;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static interviewCake.MergeMeetings.mergeRanges;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMergeMeetings {

// tests

	@Test
	public void meetingsOverlapTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(new MergeMeetings.Meeting(1, 3), new MergeMeetings.Meeting(2, 4));
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(new MergeMeetings.Meeting(1, 4));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingsTouchTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(new MergeMeetings.Meeting(5, 6), new MergeMeetings.Meeting(6, 8));
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(new MergeMeetings.Meeting(5, 8));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingContainsOtherMeetingTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(new MergeMeetings.Meeting(1, 8), new MergeMeetings.Meeting(2, 5));
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(new MergeMeetings.Meeting(1, 8));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingsStaySeparateTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(new MergeMeetings.Meeting(1, 3), new MergeMeetings.Meeting(4, 8));
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(
						new MergeMeetings.Meeting(1, 3), new MergeMeetings.Meeting(4, 8)
		);
		assertEquals(expected, actual);
	}

	@Test
	public void multipleMergedMeetingsTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(
						new MergeMeetings.Meeting(1, 4), new MergeMeetings.Meeting(2, 5), new MergeMeetings.Meeting(5, 8));
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(new MergeMeetings.Meeting(1, 8));
		assertEquals(expected, actual);
	}

	@Test
	public void meetingsNotSortedTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(
						new MergeMeetings.Meeting(5, 8), new MergeMeetings.Meeting(1, 4), new MergeMeetings.Meeting(6, 8));
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(
						new MergeMeetings.Meeting(1, 4), new MergeMeetings.Meeting(5, 8)
		);
		assertEquals(expected, actual);
	}

	@Test
	public void oneLongMeetingContainsSmallerMeetingsTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(
						new MergeMeetings.Meeting(1, 10), new MergeMeetings.Meeting(2, 5), new MergeMeetings.Meeting(6, 8),
						new MergeMeetings.Meeting(9, 10), new MergeMeetings.Meeting(10, 12)
		);
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(
						new MergeMeetings.Meeting(1, 12)
		);
		assertEquals(expected, actual);
	}

	@Test
	public void sampleInputTest() {
		final List<MergeMeetings.Meeting> meetings = Arrays.asList(
						new MergeMeetings.Meeting(0, 1), new MergeMeetings.Meeting(3, 5), new MergeMeetings.Meeting(4, 8),
						new MergeMeetings.Meeting(10, 12), new MergeMeetings.Meeting(9, 10)
		);
		final List<MergeMeetings.Meeting> actual = mergeRanges(meetings);
		final List<MergeMeetings.Meeting> expected = Arrays.asList(
						new MergeMeetings.Meeting(0, 1), new MergeMeetings.Meeting(3, 8), new MergeMeetings.Meeting(9, 12)
		);
		assertEquals(expected, actual);
	}

}
