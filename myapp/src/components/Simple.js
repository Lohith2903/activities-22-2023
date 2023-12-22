export function Greetings(){
    return(
        <div>
            <h2 className="txt-center">Greetings Component</h2>
        </div>
    )
}

export function Hello(props){
    // console.log("Props: ", props);
    let user = props.username;
    let age = props.age;

    return(
        <p>Hello, {user}. You are {age} years old.</p>
    )
}
