const axios = require('axios');
const cheerio = require('cheerio');
const getDataFromRemote = async () => {
    const URL = 'https://www.cricbuzz.com/cricket-match/live-scores';
    const response = await axios.get(URL);
    const {data} = response;
    return data;
}

const getScores = async () => {
    const html = await getDataFromRemote();
    const scores = [];
    const $ = cheerio.load(html);
    $('a.cb-lv-scrs-well-live').each(function (_, element){
        const scoreContainer = $(element).children().children();
        const score = $(scoreContainer).text();
console.log(score);
        scores.push(score);
    })
    return scores;
}
console.log(getScores());
