package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {
    // Simulated database storing student score information
    private static Map<String, Student> studentScores;
    
    // Initialize student data
    @Override
    public void init() {
        studentScores = new HashMap<>();
        
        // Add some sample student data
        studentScores.put("1001", new Student("1001", "Zhang San", 
            new HashMap<String, Integer>() {{
                put("Mathematics", 95);
                put("Chinese", 88);
                put("English", 92);
                put("Computer Science", 98);
            }}));
            
        studentScores.put("1002", new Student("1002", "Li Si", 
            new HashMap<String, Integer>() {{
                put("Mathematics", 85);
                put("Chinese", 92);
                put("English", 80);
                put("Computer Science", 89);
            }}));
            
        studentScores.put("1003", new Student("1003", "Wang Wu", 
            new HashMap<String, Integer>() {{
                put("Mathematics", 78);
                put("Chinese", 85);
                put("English", 90);
                put("Computer Science", 76);
            }}));
            
        studentScores.put("1004", new Student("1004", "Zhao Liu", 
            new HashMap<String, Integer>() {{
                put("Mathematics", 90);
                put("Chinese", 82);
                put("English", 88);
                put("Computer Science", 95);
            }}));
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        // Get student ID from request
        String studentId = request.getParameter("studentId");
        PrintWriter out = response.getWriter();
        
        // Generate HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>Score Query Result</title>");
        out.println("    <style>");
        out.println("        body { font-family: Arial, sans-serif; max-width: 800px; margin: 0 auto; padding: 20px; background-color: #f5f5f5; }");
        out.println("        .container { background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        out.println("        h1 { color: #333; text-align: center; }");
        out.println("        .result { margin: 20px 0; }");
        out.println("        table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
        out.println("        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }");
        out.println("        th { background-color: #f2f2f2; }");
        out.println("        .average { font-weight: bold; color: #2c3e50; }");
        out.println("        .back-link { display: inline-block; margin-top: 20px; padding: 10px 15px; background-color: #3498db; color: white; text-decoration: none; border-radius: 4px; }");
        out.println("        .back-link:hover { background-color: #2980b9; }");
        out.println("        .error { color: #e74c3c; text-align: center; padding: 20px; }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class='container'>");
        
        // Find student information and display results
        if (studentId != null && studentScores.containsKey(studentId)) {
            Student student = studentScores.get(studentId);
            
            out.println("        <h1>" + student.getName() + "'s Score Results</h1>");
            out.println("        <div class='result'>");
            out.println("            <p><strong>Student ID:</strong> " + student.getId() + "</p>");
            out.println("            <table>");
            out.println("                <tr><th>Subject</th><th>Score</th></tr>");
            
            // Display scores for each subject
            int total = 0;
            for (Map.Entry<String, Integer> entry : student.getScores().entrySet()) {
                out.println("                <tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>");
                total += entry.getValue();
            }
            
            // Calculate and display average score
            double average = (double) total / student.getScores().size();
            out.println("                <tr><td class='average'>Average</td><td class='average'>" + String.format("%.1f", average) + "</td></tr>");
            out.println("            </table>");
            out.println("        </div>");
        } else {
            // Student not found
            out.println("        <h1>Query Result</h1>");
            out.println("        <div class='error'>");
            out.println("            <p>No student information found with ID '" + (studentId != null ? studentId : "") + "'</p>");
            out.println("            <p>Please check if the student ID is correct</p>");
            out.println("        </div>");
        }
        
        // Back to query page link
        out.println("        <a href='index.html' class='back-link'>Return to Query Page</a>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    // Student class to store student information and scores
    private static class Student {
        private String id;
        private String name;
        private Map<String, Integer> scores;
        
        public Student(String id, String name, Map<String, Integer> scores) {
            this.id = id;
            this.name = name;
            this.scores = scores;
        }
        
        public String getId() { return id; }
        public String getName() { return name; }
        public Map<String, Integer> getScores() { return scores; }
    }
}
    