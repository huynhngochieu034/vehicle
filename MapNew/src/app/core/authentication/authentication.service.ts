
import { Injectable } from '@angular/core';
import { Observable, of, Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { TrafficUrlService } from '../service/traffic-url/traffic-url.service';



export interface Credentials {
  username: String;
  token: string;
  isAdmin: boolean;
}

export interface LoginContext {
  username: String;
  password: String;
  remember?: boolean;
}

export class User{
  constructor(
    public username:string,
    public roles:string,
    public status:string,
     ) {}
    
    //public status:string,
}

/**
 * Key determine 'credential' in cache/local storage.
 */
const credentialsKey = 'credentials';

/**
 * Provides a base for authentication workflow.
 * The Credentials interface as well as login/logout methods should be replaced with proper implementation.
 */
@Injectable()
export class AuthenticationService {
  public user=new User(null,null,null);


  private _credentials: Credentials | null;
  authChanged$ = new Subject();
  private _tempUserName: String;

  constructor(private mockUpService: TrafficUrlService) {
    const savedCredentials = sessionStorage.getItem(credentialsKey) || localStorage.getItem(credentialsKey);
    if (savedCredentials) {
      this._credentials = JSON.parse(savedCredentials);
    }
  }

   /**
   * Authenticates the user.
   * @param context The login parameters.
   */
  // login(context: LoginContext) {
  //  this.mockUpService.login(context.username, context.password).subscribe(data => this.user = data);
     
      
  //        //return data;
  //       if(this.user.username!==null){
  //         const dataUser = {
  //           username: this.user.username,
  //           token: '123456',
  //           isAdmin: this.user.roles.toLowerCase() === 'admin' ? true : false
  //        };
  //     sessionStorage.setItem('username',dataUser.username);
  //     this._tempUserName = dataUser.username;
  //     this.setCredentials(dataUser, context.remember);
  //         return of(true);
  //     } 
  //        else return of(false);
  // }

  /**
   * Authenticates the user.
   * @param context The login parameters.
   */
  login(context: LoginContext): Observable<any> {
    const data = {
      username: context.username,
      token: '123456',
      isAdmin: context.username.toLowerCase() === 'admin' ? true : false
    };
    this._tempUserName = context.username;
    this.setCredentials(data, context.remember);
    return of(true);
  }

  /**
   * Logs out the user and clear credentials.
   */
  logout(): Observable<any> {
    if (!this._tempUserName) {
      let logOut = JSON.parse(localStorage.getItem(credentialsKey));
      this._tempUserName = logOut.username;
    }
    this.setCredentials();
    return of(this._tempUserName);
  }

  /**
   * Checks is the user is authenticated.
   */
  isAuthenticated(): boolean {
    return !!this._credentials;
  }

  /**
   * Gets the user credentials.
   */
  get credentials(): Credentials | null {
    return this._credentials;
  }

  /**
   * Sets the user credentials.
   * The credentials may be persisted across sessions by setting the `remember` parameter to true.
   * Otherwise, the credentials are only persisted for the current session.
   * @param credentials The user credentials.
   * @param remember True to remember credentials across sessions.
   */
  private setCredentials(credentials?: Credentials, remember?: boolean) {
    this._credentials = credentials || null;
    if (credentials) {
      const storage = remember ? localStorage : sessionStorage;
      storage.setItem(credentialsKey, JSON.stringify(credentials));
      this.authChanged$.next();
    } else {
      sessionStorage.removeItem(credentialsKey);
      localStorage.removeItem(credentialsKey);
    }
  }
}
