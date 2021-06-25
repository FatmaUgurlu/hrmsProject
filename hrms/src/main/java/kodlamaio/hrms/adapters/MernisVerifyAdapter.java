package kodlamaio.hrms.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisVerifyAdapter  implements VerifyApiService<Candidate>{

	@Override
	public boolean VerifyApiControl(Candidate candidate) {
		
		return true;
	}

}
