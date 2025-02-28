import java.util.Scanner;

class Applicant {
    String degree;
    boolean pythonCourse, softwareEngCourse, agileCourse;
    int pythonExperience, dataExperience, projectManagementExperience, agileProjectExperience;
    boolean usedGit;
    boolean hasPMICert;
    boolean hasMasters;

    public Applicant(Scanner scanner) {
        System.out.println("Enter your highest degree (e.g., Bachelor in CS, Masters in CS):");
        degree = scanner.nextLine().trim();

        System.out.println("Have you completed Python coursework? (true/false):");
        pythonCourse = scanner.nextBoolean();

        System.out.println("Have you completed Software Engineering coursework? (true/false):");
        softwareEngCourse = scanner.nextBoolean();

        System.out.println("Have you completed an Agile course? (true/false):");
        agileCourse = scanner.nextBoolean();

        System.out.println("Years of Python development experience:");
        pythonExperience = scanner.nextInt();

        System.out.println("Years of data development experience:");
        dataExperience = scanner.nextInt();

        System.out.println("Years of project management experience:");
        projectManagementExperience = scanner.nextInt();

        System.out.println("Years of experience in Agile projects:");
        agileProjectExperience = scanner.nextInt();

        System.out.println("Have you used Git? (true/false):");
        usedGit = scanner.nextBoolean();

        System.out.println("Do you have PMI Lean Project Management Certification? (true/false):");
        hasPMICert = scanner.nextBoolean();

        System.out.println("Do you have a Master's in CS? (true/false):");
        hasMasters = scanner.nextBoolean();
    }
}

class ExpertSystem {
    public static void determineQualification(Applicant applicant) {
        boolean qualified = false;

        if (applicant.pythonExperience >= 3 && applicant.dataExperience >= 1 && applicant.agileProjectExperience >= 1
                && applicant.usedGit && "Bachelor in CS".equalsIgnoreCase(applicant.degree)) {
            System.out.println("Application accepted for Python Engineer position. You meet the requirements: 3+ years of Python experience, 1+ year of data development, experience in Agile projects, Git knowledge, and a Bachelor's in CS.");
            qualified = true;
        } else {
            System.out.println("Application denied for Python Engineer position. Reasons:");
            if (applicant.pythonExperience < 3) System.out.println("- Less than 3 years of Python development experience");
            if (applicant.dataExperience < 1) System.out.println("- Less than 1 year of data development experience");
            if (applicant.agileProjectExperience < 1) System.out.println("- No experience in Agile projects");
            if (!applicant.usedGit) System.out.println("- No experience using Git");
            if (!"Bachelor in CS".equalsIgnoreCase(applicant.degree)) System.out.println("- Degree is not a Bachelor in CS");
        }

        if (applicant.projectManagementExperience >= 3 && applicant.agileProjectExperience >= 2 && applicant.hasPMICert) {
            System.out.println("Application accepted for Project Manager position. You meet the requirements: 3+ years in software project management, 2+ years in Agile projects, and PMI Lean Project Management Certification.");
            qualified = true;
        } else {
            System.out.println("Application denied for Project Manager position. Reasons:");
            if (applicant.projectManagementExperience < 3) System.out.println("- Less than 3 years in project management");
            if (applicant.agileProjectExperience < 2) System.out.println("- Less than 2 years in Agile projects");
            if (!applicant.hasPMICert) System.out.println("- Lacks PMI Lean Project Management Certification");
        }

        if (applicant.pythonExperience >= 3 && applicant.dataExperience >= 2 && applicant.hasMasters) {
            System.out.println("Application accepted for Senior Knowledge Engineer position. You meet the requirements: 3+ years using Python for expert systems, 2+ years in data architecture, and a Master's in CS.");
            qualified = true;
        } else {
            System.out.println("Application denied for Senior Knowledge Engineer position. Reasons:");
            if (applicant.pythonExperience < 3) System.out.println("- Less than 3 years using Python for expert systems");
            if (applicant.dataExperience < 2) System.out.println("- Less than 2 years in data architecture");
            if (!applicant.hasMasters) System.out.println("- No Master's in CS");
        }

        if (applicant.pythonCourse && applicant.softwareEngCourse && "Bachelor in CS".equalsIgnoreCase(applicant.degree)) {
            System.out.println("Application accepted for Entry-Level Python Engineer position. You meet the requirements: Python coursework, Software Engineering coursework, and a Bachelor's in CS.");
            qualified = true;
        } else {
            System.out.println("Application denied for Entry-Level Python Engineer position. Reasons:");
            if (!applicant.pythonCourse) System.out.println("- No Python coursework");
            if (!applicant.softwareEngCourse) System.out.println("- No Software Engineering coursework");
            if (!"Bachelor in CS".equalsIgnoreCase(applicant.degree)) System.out.println("- Degree is not a Bachelor in CS");
        }

        if (!qualified) {
            System.out.println("Sorry, you do not meet the qualifications for any available positions. Please consider gaining additional experience or certifications.");
        }
    }
}

public class JobExpertSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Applicant applicant = new Applicant(scanner);
        ExpertSystem.determineQualification(applicant);
        scanner.close();
    }
}
