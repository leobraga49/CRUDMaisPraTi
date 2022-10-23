package br.com.alfamidia.controller;

import br.com.alfamidia.model.PersonModel;
import br.com.alfamidia.model.StudentModel;
import br.com.alfamidia.view.Screen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonController{
    Scanner scanner = new Scanner(System.in);
    ArrayList<PersonModel> people;
    ArrayList<StudentModel> students;

    public PersonController() {
        people = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void savePerson(){
        System.out.println("                Nome:                                       ");
        String name = scanner.nextLine();
        System.out.println("                Telefone:                                   ");
        String phone = scanner.nextLine();
        System.out.println("                Data de nascimento:                         ");
        String birthDate = scanner.nextLine();
        LocalDate registrationDate = LocalDate.now();
        LocalDate changeDate = LocalDate.now();
        var person = new PersonModel(name, phone, birthDate, registrationDate, changeDate);
        people.add(person);

    }

    public void saveStudent(){
        System.out.println("                Nome:                                       ");
        String name = scanner.nextLine();
        System.out.println("                Telefone:                                   ");
        String phone = scanner.nextLine();
        System.out.println("                Data de nascimento:                         ");
        String birthDate = scanner.nextLine();
        System.out.println("                Nota final:                                 ");
        float finalGrade = Float.parseFloat(scanner.nextLine());
    }

    public void saveUserTest(){
        Screen.addUserMenu();
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> savePerson();
            case 2 -> saveStudent();
            case 3 -> Screen.mainMenu();
            default -> System.out.println("Digite uma opção válida");
        }

    }

    public void saveUser() {
            System.out.println("------------------------------------------------------------");
            System.out.println("                Informe os dados para cadastro              ");
            System.out.println("                Nome:                                       ");
            String name = scanner.nextLine();
            System.out.println("                Telefone:                                   ");
            String phone = scanner.nextLine();
            System.out.println("                Data de nascimento:                         ");
            String birthDate = scanner.nextLine();
            System.out.println("                Caso não seja Aluno, informe 0 como nota!   ");
            System.out.println("                Nota final:                                 ");
            float finalGrade = Float.parseFloat(scanner.nextLine());
            System.out.println("------------------------------------------------------------");
            if (name.isEmpty() || phone.isEmpty() || birthDate.isEmpty()) {
                System.out.println("Os campos não podem estar vazios!");
                saveUser();
            } else {
                LocalDate registrationDate = LocalDate.now();
                LocalDate changeDate = LocalDate.now();
                if (finalGrade == 0) {
                    var person = new PersonModel(name, phone, birthDate, registrationDate, changeDate);
                    people.add(person);
                } else {
                    var student = new StudentModel(name, phone, birthDate, registrationDate, changeDate, finalGrade);
                    students.add(student);
                }
            }
    }

    public void listAll() {
        System.out.println("------------------------------------------------------------");
        System.out.println("                Informe quem você deseja listar             ");
        System.out.println("                1 - Pessoa                                  ");
        System.out.println("                2 - Aluno                                   ");
        System.out.println("                3 - Voltar ao menu                          ");
        int option = scanner.nextInt();

        if (option == 1) {
            if (people.size() == 0) {
                System.out.println("Nenhuma pessoa cadastrada");
            } else {
                listAllPeople();
            }
        } else if (option == 2) {
            if (students.size() == 0) {
                System.out.println("Nenhum aluno cadastrado");
            } else {
                listAllStudents();
            }
        } else if (option == 3) {
            Screen.startApp();
        } else {
            System.out.println("Digite uma opção válida");
        }
    }

    public void listAllPeople() {
        System.out.println("                      Lista de pessoas:                     ");
        int i = 1;
        for (PersonModel person : people) {
            System.out.println(i + " - ");
            System.out.println(person);
            i++;
        }
    }

    public void listAllStudents() {
        System.out.println("------------------------------------------------------------");
        System.out.println("                      Lista de alunos:                     ");
        int i = 1;
        for (StudentModel student : students) {
            System.out.println(i + " - ");
            System.out.println(student);
            i++;
        }
    }

    public void updateUser() {
        Screen.updateMenu();
        int option = scanner.nextInt();

        if (option == 1) {
            if (people.size() == 0) {
                System.out.println("Nenhuma pessoa cadastrada");
            } else {
                listAllPeople();
                System.out.println("------------------------------------------------------------");
                System.out.println("          Informe o nome de quem você deseja atualizar      ");
                scanner.nextLine();
                String registrationName = scanner.nextLine();
                for (PersonModel person : people) {
                    if (person.getName().equalsIgnoreCase(registrationName)) {
                        deletePerson(registrationName);
                        saveUser();
                        System.out.println("Pessoa atualizada!");
                    } else {
                        System.out.println("Digite um nome válido");
                    }
                }
            }
        } else if (option == 2) {
            if (students.size() == 0) {
                System.out.println("Nenhum aluno cadastrado");
            } else {
                listAllStudents();
                System.out.println("------------------------------------------------------------");
                System.out.println("          Informe o nome de quem você deseja atualizar      ");
                scanner.nextLine();
                String registrationName = scanner.nextLine();
                for (StudentModel student : students) {
                    if (student.getName().equalsIgnoreCase(registrationName)) {
                        deleteStudent(registrationName);
                        saveUser();
                        System.out.println("Aluno atualizado!");
                    } else {
                        System.out.println("Digite um nome válido");
                    }
                }
            }
        } else if (option == 3) {
            Screen.startApp();
        } else {
            System.out.println("Digite uma opção válida!");
        }
    }

    public void deleteUser() {
        Screen.deleteMenu();
        int option = scanner.nextInt();

        if (option == 1) {
            if (people.size() == 0) {
                System.out.println("Nenhuma pessoa cadastrada");
            } else {
                listAllPeople();
                System.out.println("------------------------------------------------------------");
                System.out.println("          Informe o nome de quem você deseja deletar      ");
                scanner.nextLine();
                String registrationName = scanner.nextLine();
                for (PersonModel person : people) {
                    if (person.getName().equalsIgnoreCase(registrationName)) {
                        deletePerson(registrationName);
                        System.out.println("Pessoa deletada!");
                        return;
                    } else {
                        System.out.println("Digite um nome válido");
                    }
                }
            }
        } else if (option == 2) {
            if (students.size() == 0) {
                System.out.println("Nenhum aluno cadastrado");
            } else {
                listAllStudents();
                System.out.println("------------------------------------------------------------");
                System.out.println("          Informe o nome de quem você deseja deletar      ");
                scanner.nextLine();
                String registrationName = scanner.nextLine();
                for (StudentModel student : students) {
                    if (student.getName().equalsIgnoreCase(registrationName)) {
                        deleteStudent(registrationName);
                        System.out.println("Aluno deletado!");
                        return;
                    } else {
                        System.out.println("Digite um nome válido");
                    }
                }
            }
        } else if (option == 3) {
            Screen.startApp();
        } else {
            System.out.println("Digite um nome válido");
        }
    }

    public void deletePerson(String registrationName) {
        people.removeIf(person -> person.getName().equalsIgnoreCase(registrationName));
    }

    public void deleteStudent(String registrationName) {
        students.removeIf(student -> student.getName().equalsIgnoreCase(registrationName));
    }

    public void closeApp() {
        System.out.println("Encerrando programa!");
        System.exit(0);
    }
}
