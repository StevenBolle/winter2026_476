from flask import Flask, render_template, request
from HotelClient import HotelClient


app = Flask(__name__)

# use flask to handle web app GUI
# create a single client instance, will persist across requests
client = HotelClient()

@app.route("/", methods=["GET", "POST"])
def index():
    result = None

    if request.method == "POST":
        try:
            bid = float(request.form["bid"])
            result = client.submitBid(bid)
        except:
            result = "Invalid input. Enter a numeric value to bid"

    return render_template("index.html", result=result)

if __name__ == "__main__":
    app.run(debug=True)