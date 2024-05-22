package chapter07;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;
	
	@Override
	public List<StudentVO> all(StudentVO vo) {
		return dao.all(vo);
	}
	@Override
	public List<Map<String, Object>> all2(Map<String, Object> vo) {
		return dao.all2(vo);
	}
	
	public StudentVO view(int studno) {
		return dao.view(studno);
	}

}
