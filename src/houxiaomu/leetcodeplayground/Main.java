package houxiaomu.leetcodeplayground;

public class Main {

    public static void main(String[] args) {
//        runSolution("twosum");
//        runSolution("add_two_numbers");
//        runSolution("same_tree");
//        runSolution("symmetric_tree");
//        runSolution("binary_tree_level_order_traversal");
//        runSolution("binary_tree_zigzag_level_order_traversal");
//        runSolution("validate_binary_search_tree");
//        runSolution("restore_ip_addresses");
//        runSolution("reverse_linked_list_ii");
//        runSolution("decode_ways"); //NOT FINISHED
//        runSolution("gray_code");
//        runSolution("partition_list");
//        runSolution("largest_rectangle_in_histogram");
//        runSolution("zigzag_conversion");
//        runSolution("palindrome_number");
//        runSolution("integer_to_roman");
//        runSolution("roman_to_integer");
//        runSolution("longest_common_prefix");
//        runSolution("three_sum");
//        runSolution("three_sum_closest");
//        runSolution("letter_combinations_of_a_phone_number");
//        runSolution("remove_nth_node_from_end_of_list");
//        runSolution("valid_parentheses");
//        runSolution("merge_two_sorted_lists");
//        runSolution("generate_parentheses");
//        runSolution("merge_k_sorted_lists");
//        runSolution("swap_nodes_in_pairs");
//        runSolution("reverse_nodes_in_k_group");
//        runSolution("remove_duplicates_from_sorted_array");
//        runSolution("search_for_a_range");
//        runSolution("search_insert_position");
//        runSolution("remove_duplicates_from_sorted_array");
//        runSolution("remove_element");
//        runSolution("implement_strstr");
//        runSolution("divide_two_integers");
//        runSolution("valid_sudoku");
//        runSolution("sudoku_solver");
//        runSolution("count_and_say");
//        runSolution("combination_sum");
//        runSolution("combination_sum_2");
//        runSolution("multiply_strings");
//        runSolution("permutations");
//        runSolution("permutations_ii");
//        runSolution("rotate_image");
//        runSolution("anagrams");
//        runSolution("maximum_subarray");
//        runSolution("spiral_matrix");
//        runSolution("jump_game");
//        runSolution("length_of_last_word");
//        runSolution("spiral_matrix_ii");
//        runSolution("permutation_sequence");
//        runSolution("rotate_list");
//        runSolution("plus_one");
//        runSolution("add_binary");
//        runSolution("unique_paths");
//        runSolution("unique_paths2");
        runSolution("minimum_path_sum");
    }

    private static void runSolution(String solutionName) {
        System.out.println("running " + solutionName);
        String className = Main.class.getPackage().getName() + "." + solutionName + ".Solution";
        try {
            Class<?> clazz = Class.forName(className);
            BaseSolution solution = (BaseSolution) clazz.newInstance();
            solution.runTestCases();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
