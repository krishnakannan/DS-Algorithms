import java.util.*;
import java.lang.*;

class PartitionLabels {
	
	public static void main(String arfs[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		PartitionLabels pl = new PartitionLabels();
		System.out.println(pl.partitionLabels(s));
	}

	class Label {
		char val;
		int start;
		int end;
		public Label(char val, int start, int end) {
			this.val = val;
			this.start = start;
			this.end = end;
		}
	}

	Label[] charMap = new Label[26];

    public List<Integer> partitionLabels(String S) {
    	List<Integer> partitions = new ArrayList<>();
        char[] sArray = S.toCharArray();
        Label[] labels;
        int size = 0;
        for (int i = 0; i < sArray.length; i++) {
        	if (charMap[sArray[i] - 'a'] != null) {
        		charMap[sArray[i] - 'a'].end = i + 1;
        	} else { 
        		size++;       		
        		charMap[sArray[i] - 'a'] = new Label(sArray[i], i + 1, i + 1);        		
        	}
        }

        labels = new Label[size];
        int index = 0;
        for (int i = 0; i < charMap.length; i++) {
        	if (charMap[i] != null) {
        		labels[index] = charMap[i];
        		index++;
        	}
        }

        Arrays.sort(labels, new Comparator<Label>(){
        	public int compare(Label a, Label b) {
        		return a.start - b.start;
        	}
        });

        for (int i = 0; i < labels.length; i++) {
        	System.out.println(labels[i].val + " Start " + labels[i].start + " End " + labels[i].end);
        }        
        int min = 0;
        int max = 0;
        int currentPartition = 0;
        for (int i = 0; i < labels.length; i++) {
        	if (min == 0 && max == 0) {
        		min = labels[i].start;
        		max = labels[i].end;
        		currentPartition = max - min + 1;
        	} else {
        		if (labels[i].end < max) {
        			continue;
        		} else if (labels[i].end > max && labels[i].start < max) {
        			max = labels[i].end;
        			currentPartition = max - min + 1;
        		} else if (labels[i].end > max && labels[i].start > max) {
        			partitions.add(currentPartition);
        			min = labels[i].start;
        			max = labels[i].end;
        			currentPartition = max - min + 1;
        		}
        	}
        }
        partitions.add(currentPartition);
        return partitions;
    }
}