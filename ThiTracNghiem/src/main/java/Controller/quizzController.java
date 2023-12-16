package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import Model.bean.*;
import Model.bo.*;




@WebServlet("/quizzController")
public class quizzController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    AccountBO accountBO = new AccountBO();
    AccountInfoBO accountInfoBO = new AccountInfoBO();
    QuestionBO questionBO = new QuestionBO();
    ResultBO resultBO = new ResultBO();
    TestBO testBO = new TestBO();

    public quizzController() {
        super();    
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        
        String mod = request.getParameter("mod");
        if("0".equals(mod)) {
			response.sendRedirect("/index.jsp");
        }
        else if("Login".equals(mod)) {
        	
        	String username = (String)request.getParameter("username");
        	String password = (String)request.getParameter("password");
        	int ID_Account = accountBO.checkLoginAndGetID(username, password);
        	int role = accountBO.getRoleByID(ID_Account);
        	
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("ID_Account", ID_Account);
            request.getSession().setAttribute("role", role);

//        	System.out.println(ID_Account);
//        	System.out.println(role);
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Menu.jsp");
            rd.forward(request, response);

        }
        else if("Logout".equals(mod)) {
        	accountBO.Logout();
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }

        else if("StudentList".equals(mod)) {
        	List<AccountInfoBEAN> list = accountInfoBO.getAllStudentInfo();
            request.setAttribute("list", list);
            
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/StudentInfoList.jsp");
            rd.forward(request, response);
        }
        else if("AccountList".equals(mod)) {
        	List<AccountBEAN> list = accountBO.getAllAccount();
        	request.setAttribute("list", list);
            
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/AccountList.jsp");
            rd.forward(request, response);
        }
        else if("QuestionList".equals(mod)) {
        	
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));
        	List<QuestionBEAN> list = questionBO.getAllQuestionByIDTest(ID_Test);
        	request.setAttribute("list", list);
        	request.setAttribute("ID_Test", ID_Test);

            
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuestionList.jsp");
            rd.forward(request, response);
        }
        else if("UpdatePassForm".equals(mod)) {
        	String password = (String)request.getParameter("password");
        	request.setAttribute("password", password);
        	request.setAttribute("ID_Account", (String)request.getParameter("ID_Account"));

        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/UpdatePassForm.jsp");
            rd.forward(request, response);
        	
        }

        else if("UpdatePass".equals(mod)) {
        	String password = (String)request.getParameter("password");
        	int ID_Account =  Integer.parseInt((String)request.getParameter("ID_Account"));
        	accountBO.updatePassword(ID_Account, password);
        	
        	List<AccountBEAN> list = accountBO.getAllAccount();
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/AccountList.jsp");
            rd.forward(request, response);
        }
        else if("TestList".equals(mod)) {
        	List<TestBEAN> list = testBO.getAllTest();
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/TestList.jsp");
            rd.forward(request, response);
        }
        else if("JoinTest".equals(mod)) {
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));

        	List<QuestionBEAN> list = questionBO.getAllQuestionByIDTest(ID_Test);
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/JoinTest.jsp");
            rd.forward(request, response);
        }
        else if("SubmitTest".equals(mod)) {
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));        	
        	
        	int point = 0;
        	for (String parameterName : request.getParameterMap().keySet()) {
                if (parameterName.startsWith("answer_")) {
                    String questionId = parameterName.substring("answer_".length());
                    String answer = request.getParameter(parameterName);
                    // Process the answer here (e.g., store it in a database, calculate score, etc.)
                    boolean check =questionBO.checkAnswer(ID_Test, Integer.parseInt(questionId), answer);
                    if(check) {
                    	point += 1;
                    }
                }
            }
        	int Mark = questionBO.getMark(ID_Test, point);
        	System.out.println("Mark " + Mark);
    		int ID_Account = (Integer) request.getSession().getAttribute("ID_Account");

			System.out.println("ID_Test: " + ID_Test);
			System.out.println("ID_Account: " + ID_Account);
    		resultBO.submitResult(ID_Test, ID_Account, Mark);
    		
    		response.sendRedirect("Menu.jsp");
    		
        }
        else if("AllList".equals(mod)) {
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));
        	ResultTestAccountInfoBEAN temp = new ResultTestAccountInfoBEAN();
        	List<ResultTestAccountInfoBEAN> list;
        	if((int)request.getSession().getAttribute("role")==0) {
        		list = temp.getAllByIDTest(ID_Test);        		
        	}
        	else {
        		list = temp.getAllByID_Account((int)request.getSession().getAttribute("ID_Account"), ID_Test);        		

        	}
        	request.setAttribute("list", list);
        	request.setAttribute("ID_Test", ID_Test);

        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/AllList.jsp");
            rd.forward(request, response);        	
        }
        else if("Search".equals(mod)) {
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));
        	String search =  (String)request.getParameter("search");

        	ResultTestAccountInfoBEAN temp = new ResultTestAccountInfoBEAN();
        	List<ResultTestAccountInfoBEAN> iniList;
        	if((int)request.getSession().getAttribute("role")==0) {
        		iniList = temp.getAllByIDTest(ID_Test);        		
        	}
        	else {
        		iniList = temp.getAllByID_Account((int)request.getSession().getAttribute("ID_Account"), ID_Test);        		

        	}
        	
        	List<ResultTestAccountInfoBEAN> list = new ArrayList();
        	for(ResultTestAccountInfoBEAN tempp: iniList) {
        		if(String.valueOf(tempp.info.MSSV).equals(search)) {
        			list.add(tempp);
        		}
        	}

        	request.setAttribute("list", list);
        	request.setAttribute("ID_Test", ID_Test);

        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/AllList.jsp");
            rd.forward(request, response);
        	
        }

        else if("UpdateQuestionForm".equals(mod)) {
        	int ID_Question =  Integer.parseInt((String)request.getParameter("ID_Question"));
        	QuestionBEAN question = questionBO.getQuestionByID(ID_Question);
        	
        	request.setAttribute("question", question);
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuestionUpdateForm.jsp");
            rd.forward(request, response);
        }
        else if("UpdateQuestion".equals(mod)) {
        	int ID_Question =  Integer.parseInt((String)request.getParameter("ID_Question"));
        	String name = (String)request.getParameter("name");
        	String opt1 = (String)request.getParameter("opt1");
        	String opt2 = (String)request.getParameter("opt2");
        	String opt3 = (String)request.getParameter("opt3");
        	String opt4 = (String)request.getParameter("opt4");
        	String answer = (String)request.getParameter("answer");
        	System.out.println("opt4: " + opt4);
        	
        	questionBO.updateQuestion(ID_Question, name, opt1, opt2, opt3, opt4, answer);

        	List<TestBEAN> list = testBO.getAllTest();
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/TestList.jsp");
            rd.forward(request, response);
        }
        else if("DeleteQuestion".equals(mod)) {
        	int ID_Question =  Integer.parseInt((String)request.getParameter("ID_Question"));
        	questionBO.deleteQuestion(ID_Question);
        	
        	List<TestBEAN> list = testBO.getAllTest();
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/TestList.jsp");
            rd.forward(request, response);
        }
        else if("CreateQuestionForm".equals(mod)) {
        	int ID_Test=  Integer.parseInt((String)request.getParameter("ID_Test"));
        	request.setAttribute("ID_Test", ID_Test);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuestionCreateForm.jsp");
            rd.forward(request, response);
        }
        else if("CreateQuestion".equals(mod)) {
        	String name = (String)request.getParameter("name");
        	String opt1 = (String)request.getParameter("opt1");
        	String opt2 = (String)request.getParameter("opt2");
        	String opt3 = (String)request.getParameter("opt3");
        	String opt4 = (String)request.getParameter("opt4");
        	String answer = (String)request.getParameter("answer");
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));

        	
        	questionBO.createQuestion(ID_Test, name, opt1, opt2, opt3, opt4, answer);

        	List<TestBEAN> list = testBO.getAllTest();
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/TestList.jsp");
            rd.forward(request, response);   
        }
        else if("CreateTest".equals(mod)) {
        	String name = (String)request.getParameter("name");
        	testBO.createTest(name);
        	
        	List<TestBEAN> list = testBO.getAllTest();
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/TestList.jsp");
            rd.forward(request, response);        	
        }
        else {
            // Handle other cases or provide a default behavior
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid mod parameter");
        }
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
