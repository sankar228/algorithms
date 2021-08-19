package algorithms;

import java.util.*;

public class SortTwoList {

    public static void main(String[] args) {
        List<Integer> arrival = new ArrayList<>(Arrays.asList(1,3,3,5,6));
        List<Integer> duration = new ArrayList<>(Arrays.asList(1,1,1,1,2));

        SortTwoList obj = new SortTwoList();
        System.out.println(obj.maxNumMeetings(arrival, duration));

    }

    public int maxNumMeetings(List<Integer> arrival, List<Integer> duration){

        List<Meeting> meetings = new ArrayList();
        int maxNumMeetings = 0;

        for(int i=0; i < arrival.size(); i++){
            meetings.add(new Meeting(arrival.get(i), duration.get(i)));
        }

        Collections.sort(meetings);

        int meetingTime = 0;
        for(int i=0,j= i + 1; i < meetings.size() - 1;){

            if(meetings.get(i).arrival == meetings.get(j).arrival){
                meetingTime =0; j ++; continue;
            }
            if(i < j ) {
                if(meetingTime > 0){
                    meetingTime += (meetings.get(i).duration);
                }else
                    meetingTime += (meetings.get(i).arrival + meetings.get(i).duration);
            }else {
                meetingTime = (meetings.get(i).arrival + meetings.get(i).duration);
            }

            if(meetingTime <= meetings.get(j).arrival){
                maxNumMeetings ++;
            }
            i++;
        }
        return maxNumMeetings + 1;
    }

    class Meeting implements Comparable{
        int arrival;
        int duration;

        Meeting(int arrival, int duration){
            this.arrival = arrival;
            this.duration = duration;
        }

        @Override
        public int compareTo(Object meeting){
            return this.arrival - ((Meeting)meeting).arrival;
        }
    }
}
