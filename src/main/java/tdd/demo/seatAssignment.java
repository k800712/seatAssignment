package tdd.demo;

import java.util.*;

public class seatAssignment {

    private static final int FRONT_SEATS = 4;
    private static final int MIDDLE_SEATS = 8;
    private static final int BACK_SEATS = 4;
    private static final int TOTAL_SEATS = FRONT_SEATS + MIDDLE_SEATS + BACK_SEATS;

    public static void main(String[] args) {
        List<String> people = new ArrayList<>(Arrays.asList(
                "윤찬영", "정해준", "권상윤", "문인혁", "허재", "이호연",
                "윤태우", "김성락", "전지예", "황승혁", "이채현", "황효진",
                "김민성", "박현지", "문성희", "추민영"
        ));

        Map<String, List<String>> seatingArrangement = assignSeats(people);
        Map<Integer, List<String>> teams = assignTeams(seatingArrangement);
        Map<String, String> seatNumbers = assignSeatNumbers(teams);

        System.out.println("앞좌석: " + seatingArrangement.get("front"));
        System.out.println("중간좌석: " + seatingArrangement.get("middle"));
        System.out.println("뒷좌석: " + seatingArrangement.get("back"));

        for (int i = 1; i <= 4; i++) {
            System.out.println("팀 " + i + ":");
            for (String member : teams.get(i)) {
                System.out.println(member + " - 좌석 번호: " + seatNumbers.get(member));
            }
            System.out.println();
        }
    }

    public static Map<String, List<String>> assignSeats(List<String> people) {
        Collections.shuffle(people);

        Map<String, List<String>> seatingArrangement = new HashMap<>();
        seatingArrangement.put("front", new ArrayList<>());
        seatingArrangement.put("middle", new ArrayList<>());
        seatingArrangement.put("back", new ArrayList<>());

        Scanner scanner = new Scanner(System.in);

        for (String person : people) {
            boolean assigned = false;
            while (!assigned) {
                System.out.println(person + "의 좌석을 선택하세요 (1: 앞좌석, 2: 중간좌석, 3: 뒷좌석):");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        if (seatingArrangement.get("front").size() < FRONT_SEATS) {
                            seatingArrangement.get("front").add(person);
                            assigned = true;
                        } else {
                            System.out.println("앞좌석이 꽉 찼습니다. 다른 좌석을 선택해주세요.");
                        }
                        break;
                    case 2:
                        if (seatingArrangement.get("middle").size() < MIDDLE_SEATS) {
                            seatingArrangement.get("middle").add(person);
                            assigned = true;
                        } else {
                            System.out.println("중간좌석이 꽉 찼습니다. 다른 좌석을 선택해주세요.");
                        }
                        break;
                    case 3:
                        if (seatingArrangement.get("back").size() < BACK_SEATS) {
                            seatingArrangement.get("back").add(person);
                            assigned = true;
                        } else {
                            System.out.println("뒷좌석이 꽉 찼습니다. 다른 좌석을 선택해주세요.");
                        }
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                }
            }
        }
        scanner.close();

        return seatingArrangement;
    }

    private static Map<Integer, List<String>> assignTeams(Map<String, List<String>> seatingArrangement) {
        Map<Integer, List<String>> teams = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            teams.put(i, new ArrayList<>());
        }

        String[] sections = {"front", "middle", "back"};
        int teamNumber = 1;

        for (String section : sections) {
            List<String> sectionSeats = new ArrayList<>(seatingArrangement.get(section));
            Collections.shuffle(sectionSeats);

            for (int i = 0; i < sectionSeats.size(); i += 4) {
                List<String> teamMembers = sectionSeats.subList(i, Math.min(i + 4, sectionSeats.size()));
                teams.get(teamNumber).addAll(teamMembers);
                teamNumber++;

                if (teamNumber > 4) {
                    teamNumber = 1;
                }
            }
        }

        return teams;
    }

    private static Map<String, String> assignSeatNumbers(Map<Integer, List<String>> teams) {
        Map<String, String> seatNumbers = new HashMap<>();
        int seatNumber = 1;

        for (int i = 1; i <= 4; i++) {
            for (String person : teams.get(i)) {
                seatNumbers.put(person, String.valueOf(seatNumber++));
            }
        }

        return seatNumbers;
    }
}