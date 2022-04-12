class User {
    
    static urlIconSilver : string = "../assets/img/iconSilver.png" 
    static urlIconGold : string = "../assets/img/iconGold.png" 

    public id: number;
    public userEmail: string;
    public password: string;
    public urlIconStatus: string;
   
    constructor(userEmail: string, password: string, urlIconStatus?: string,id?: number) {
        
      this.id = id ? id : 0;
      this.userEmail = userEmail;
      this.password = password;
      this.urlIconStatus = urlIconStatus ? urlIconStatus : "../assets/img/iconBronze.png";

    }
  
    public getId(): number {
      return this.id;
    }
    public getUserEmail(): string {
      return this.userEmail ;
    }
    public getPassword(): string {
        return this.password ;
    }
    public getUrlIconStatus(): string {
        return this.urlIconStatus ;
    }

    public setUserEmail(userEmail:string) {
      this.userEmail=userEmail ;
    }
    public setPassword(pswd:string){
      this.password=pswd;
    }
    public setUrlIconStatus(url:string) {
      this.urlIconStatus=url;
    }
   
  }
  export{User}
