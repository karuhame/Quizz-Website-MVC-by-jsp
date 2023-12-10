package Controller;

import java.io.IOException;
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
        else if("QuestionList".equals(mod)) {
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));
        	List<QuestionBEAN> list = questionBO.getAllQuestionByIDTest(ID_Test);
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/QuestionList.jsp");
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
    		int ID_Account = (Integer) request.getSession().getAttribute("ID_Account");
    		resultBO.submitResult(ID_Test, ID_Account, Mark);
        }
        else if("AllList".equals(mod)) {
        	int ID_Test =  Integer.parseInt((String)request.getParameter("ID_Test"));
        	System.out.println("Hi");
        	ResultTestAccountInfoBEAN temp = new ResultTestAccountInfoBEAN();
        	System.out.println("Hello");
        	List<ResultTestAccountInfoBEAN> list = temp.getAllByIDTest(ID_Test);
//            for (int i = 0; i < list.size(); i++) {
//            	System.out.println(list.get(i).ID_Test);
//            }
        	request.setAttribute("list", list);
        	
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/AllList.jsp");
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
