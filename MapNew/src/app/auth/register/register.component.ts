import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import { TrafficUrlService } from 'src/app/core/service/traffic-url/traffic-url.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  constructor(private formBuilder: FormBuilder, private mockUpService: TrafficUrlService, private router: Router) {}



  ngOnInit() {
    
  }

  onSubmit() {
    // this.mockUpService.createUser(this.addForm.value)
    //   .subscribe( data => {
    //     this.router.navigate(['login']);
    //   });
  }
}
