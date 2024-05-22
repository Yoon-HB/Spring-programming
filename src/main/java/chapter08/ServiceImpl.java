package chapter08;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements StudentService {
	@Autowired
	private StudentMapper mapper;
	
	@Override
	public List<StudentVO> all(StudentVO vo) {
		System.out.println(mapper.getClass().getName());
		return mapper.all(vo);
	}
	@Override
	public List<Map<String, Object>> all2(Map<String, Object> vo) {
		return null;
	}
	
	public StudentVO view(int studno) {
		return mapper.view(studno);
	}

}
