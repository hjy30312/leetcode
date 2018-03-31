
// The test point 2, 3, 4 run time out.
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {


		Set<Student> setOne = new TreeSet<>();

	}
}

class Student implements Comparable<Student> {
	int id;
	int mora;
	int talent;
	int score;
	int classType;

	public Student(int id, int mora, int talent, int h) {
		this.id = id;
		this.mora = mora;
		this.talent = talent;
		this.score = talent + mora;

		if (mora >= h && talent >= h) {
			classType = 1;
		} else if (mora >= h && talent < h) {
			classType = 2;
		} else if (mora < h && talent < h && mora >= talent) {
			classType = 3;
		} else {
			classType = 4;
		}

	}

	@Override
	public int compareTo(Student s) {

		if (this.score < s.score) {
			return 1;
		} else if (this.score > s.score) {
			return -1;
		} else {
			if (this.mora < s.mora) {
				return 1;
			} else if (this.mora > s.mora) {
				return -1;
			} else {
				if (this.id > s.id) {
					return 1;
				} else if (this.id < s.id) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
}
