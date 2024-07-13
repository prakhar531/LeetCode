// class Solution {

//     public List<Integer> survivedRobotsHealths(
//         int[] positions,
//         int[] healths,
//         String directions
//     ) {
//         int n = positions.length;
//         Integer[] indices = new Integer[n];
//         List<Integer> result = new ArrayList<>();
//         Stack<Integer> stack = new Stack<>();

//         for (int index = 0; index < n; ++index) {
//             indices[index] = index;
//         }

//         Arrays.sort(
//             indices,
//             (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
//         );

//         for (int currentIndex : indices) {
//             // Add right-moving robots to the stack
//             if (directions.charAt(currentIndex) == 'R') {
//                 stack.push(currentIndex);
//             } else {
//                 while (!stack.isEmpty() && healths[currentIndex] > 0) {
//                     // Pop the top robot from the stack for collision check
//                     int topIndex = stack.pop();

//                     // Top robot survives, current robot is destroyed
//                     if (healths[topIndex] > healths[currentIndex]) {
//                         healths[topIndex] -= 1;
//                         healths[currentIndex] = 0;
//                         stack.push(topIndex);
//                     } else if (healths[topIndex] < healths[currentIndex]) {
//                         // Current robot survives, top robot is destroyed
//                         healths[currentIndex] -= 1;
//                         healths[topIndex] = 0;
//                     } else {
//                         // Both robots are destroyed
//                         healths[currentIndex] = 0;
//                         healths[topIndex] = 0;
//                     }
//                 }
//             }
//         }

//         // Collect surviving robots
//         for (int index = 0; index < n; ++index) {
//             if (healths[index] > 0) {
//                 result.add(healths[index]);
//             }
//         }
//         return result;
//     }
// }

class Robot {
  public int index;
  public int position;
  public int health;
  public char direction;
  public Robot(int index, int position, int health, char direction) {
    this.index = index;
    this.position = position;
    this.health = health;
    this.direction = direction;
  }
}

class Solution {
  public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
    List<Integer> ans = new ArrayList<>();
    Robot[] robots = new Robot[positions.length];
    List<Robot> stack = new ArrayList<>(); // running robots

    for (int i = 0; i < positions.length; ++i)
      robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));

    Arrays.sort(robots, (a, b) -> a.position - b.position);

    for (Robot robot : robots) {
      if (robot.direction == 'R') {
        stack.add(robot);
        continue;
      }
      // Collide with robots going right if any.
      while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
        if (stack.get(stack.size() - 1).health == robot.health) {
          stack.remove(stack.size() - 1);
          robot.health = 0;
        } else if (stack.get(stack.size() - 1).health < robot.health) {
          stack.remove(stack.size() - 1);
          robot.health -= 1;
        } else { // stack[-1].health > robot.health
          stack.get(stack.size() - 1).health -= 1;
          robot.health = 0;
        }
      }
      if (robot.health > 0)
        stack.add(robot);
    }

    stack.sort((a, b) -> a.index - b.index);

    for (Robot robot : stack)
      ans.add(robot.health);

    return ans;
  }
}