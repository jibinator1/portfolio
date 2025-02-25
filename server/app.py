from flask import Flask, render_template, request, jsonify
from flask_cors import CORS

app = Flask(__name__)

CORS(app, origins=["http://localhost:5173"])

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/square', methods=['POST'])
def square():
    data = request.get_json()
    num = data['number'] ** 2
    return jsonify({'result': num})

if __name__ == '__main__':
    app.run(debug=True, port=5000)
