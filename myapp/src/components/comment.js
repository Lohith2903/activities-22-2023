export function Comment(props){

    let text = props.text;
    let date =  props.date;
    return(
        <div>
        <p>{text}</p>
        <p>{date}</p>
      </div>
    )

}