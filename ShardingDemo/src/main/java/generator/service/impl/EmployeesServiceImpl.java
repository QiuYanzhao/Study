package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Employees;
import generator.service.EmployeesService;
import generator.mapper.EmployeesMapper;
import org.springframework.stereotype.Service;

/**
* @author qyz
* @description 针对表【employees(员工记录表)】的数据库操作Service实现
* @createDate 2023-05-03 20:27:11
*/
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees>
    implements EmployeesService{

}




