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
//        runSolution("minimum_path_sum");
//        runSolution("climbing_stairs");
//        runSolution("simplify_path");
//        runSolution("search_a_2d_matrix");
//        runSolution("combinations");
//        runSolution("binary_tree_inorder_traversal");
//        runSolution("maximum_depth_of_binary_tree");
//        runSolution("subsets");
//        runSolution("combinations");
//        runSolution("unique_binary_search_trees_ii");
//        runSolution("nearest_gate_maze");
//        runSolution("count_bst_nodes_in_range");
//        runSolution("word_search");
//        runSolution("construct_binary_tree_from_preorder_and_inorder_traversal");
//        runSolution("convert_sorted_array_to_binary_search_tree");
//        runSolution("balanced_binary_tree");
//        runSolution("path_sum_ii");
//        runSolution("flatten_binary_tree_to_linked_list");
//        runSolution("best_time_to_buy_and_sell_stock");
//        runSolution("binary_tree_maximum_path_sum");
//        runSolution("sum_root_to_leaf_numbers");
//        runSolution("surrounded_regions");
//        runSolution("clone_graph");
//        runSolution("gas_station");
//        runSolution("single_number");
//        runSolution("word_break");
//        runSolution("word_break_ii");
//        runSolution("reorder_list");
//        runSolution("binary_tree_preorder_traversal");
//        runSolution("binary_tree_postorder_traversal");
//        runSolution("find_minimum_in_rotated_sorted_array");
//        runSolution("factorial_trailing_zeroes");
//        runSolution("number_of_islands");
//        runSolution("happy_number");
//        runSolution("course_schedule");
//        runSolution("implement_trie_prefix_tree");
//        runSolution("minimum_size_subarray_sum");
//        runSolution("course_schedule_ii");
//        runSolution("add_and_search_word_data_structure_design");
//        runSolution("word_search_ii");
//        runSolution("shortest_palindrome");
//        runSolution("combination_sum_iii");
//        runSolution("the_skyline_problem");
//        runSolution("contains_duplicate_ii");
//        runSolution("rectangle_area");
//        runSolution("invert_binary_tree");
//        runSolution("summary_ranges");
//        runSolution("majority_element_ii");
//        runSolution("kth_smallest_element_in_a_bst");
//        runSolution("palindrome_linked_list");
//        runSolution("lowest_common_ancestor_of_a_binary_search_tree");
        runSolution("product_of_array_except_self");
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
