import { useState } from "react";

//creating the simple text box

export function MyForm(){
    let [first, setFirst] = useState("Guest");
    let [last,setLast] = useState("");

    let handleSubmit = (e) =>{
        e.preventDefault();  //to prevent page refresh on submit
        alert(`Your name is ${first} ${last}`);
        setFirst('');
        setLast('');

    }

    return(
        <div className="w-25">
            <h2>Enter your Name</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    First Name:<br/>
                    <input type="text" className="form-control" value={first} onChange={(e)=>{setFirst(e.target.value)}} />
                </div>
                <div>
                    Last Name:<br/>
                    <input type="text" className="form-control" value={last} onChange={(e)=>{setLast(e.target.value)}} />
                </div>
                <div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    )

}