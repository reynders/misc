DATA_SIZE=10

for(i=0; i<DATA_SIZE; i++) {
	db.testdata.save({
		id: i,
		line: {
			id: DATA_SIZE + i,
			desc: "Description of the line is this and it has a number " + DATA_SIZE + i,
			quantity: Math.round(Math.random()*100)
		}
	})
}