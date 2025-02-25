import './UserInput.css';

function UserInput() {
    function square() {
        const num = document.getElementById("input").value;

        fetch('http://localhost:5000/square', {
            method: 'POST',
            body: JSON.stringify({ number: Number(num) }),//covert num to a nuymber number into a json readable format
            headers: { 'Content-Type': 'application/json' }//tells the back end were sending information
        })
            .then(response => response.json())//wait untilt we get a response
            .then(data => {//get the data
                let squaredNumber = data.result;
                console.log(squaredNumber); // Use the variable as needed
            })
            .catch(error => console.error("Error:", error));//incase there are errors
    }
    return (
        <div>
            <p>test</p>
            <input type="text" id="input" />
            <button type="button" onClick={square}>Click Me</button>
        </div>
    );
}

export default UserInput;
