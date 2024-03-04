package rentcar.controller.rentcar;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import rentcar.frontController.Controller;

public class RentCarUploadImgController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = request.getServletContext().getRealPath("/Uploads");
		
		File isDir = new File(savePath); // 이미 있는 img 경로 받아오기
		if(!isDir.isDirectory()) {
			System.out.println("디렉토리가 없습니다. 디렉토리를 새로 생성합니다.");
			isDir.mkdir();
		}
		
		int maxSize = 1024 * 1024 * 10; // 10mb
		String encType = "utf-8";
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(request, savePath, maxSize, encType, new DefaultFileRenamePolicy());
			
			String fileName = multi.getFilesystemName("uploadFile"); // 실제 서버에 올라간 파일이름
			String orginFileName = multi.getOriginalFileName("uploadFile"); // 우리가 업로드한 파일이름
			String fileType = multi.getContentType("uploadFile"); // 파일의 타입 .txt, jpg, png
			System.out.println("파일 저장된 정보 = " + savePath);
			System.out.println("실제 파일명 = " + fileName);
			System.out.println("저장 파일명 = " + orginFileName);
			System.out.println("파일 종류  = " + fileType);
			
			request.setAttribute("path", savePath);
			response.setCharacterEncoding("utf-8"); // 응답 스프링에 한글 파일 이름 있으면 깨짐 방지
			File file = multi.getFile("uploadFile");
			if(file != null) {
				response.getWriter().print(fileName);
			}
			else {
				response.getWriter().print("fail");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
